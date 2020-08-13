package com.baizhi.service.impl;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.service.CartItemService;
import com.baizhi.util.DBUtil;

public class CartItemServiceImpl implements CartItemService {

	@Override
	public void addCart(String id) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		Book book=dao.queryById(id);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Double total=0.0;
		Double save=0.0;
		HashMap<String,CartItem> map=(HashMap<String,CartItem>)session.getAttribute("cart");
		CartItem item=null;
		if(map==null){
			map=new HashMap<String,CartItem>();
			item=new CartItem();
			item.setBook(book);
			item.setCount(1);
			total=book.getDprice();
			save=book.getPrice()-book.getDprice();
		}else{
			total=(Double)session.getAttribute("total");
			save=(Double)session.getAttribute("save");
			if(map.containsKey(id)){
				item=map.get(id);
				item.setCount(item.getCount()+1);
			}else{
				item=new CartItem();
				item.setBook(book);
				item.setCount(1);
			}
			total=total+book.getDprice();
			save=save+book.getPrice()-book.getDprice();
		}
		map.put(id, item);
		session.setAttribute("cart", map);
		session.setAttribute("total", total);
		session.setAttribute("save",save);
	}

	@Override
	public void updateCart(String id, Integer count) {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		HashMap<String,CartItem> map=(HashMap<String,CartItem>)session.getAttribute("cart");
		Double total=(Double)session.getAttribute("total");
		Double save=(Double)session.getAttribute("save");
		CartItem item=map.get(id);
		//一本图书的当当价
		Double price=item.getBook().getDprice();
		//一本图书节省的价格
		Double dsave=item.getBook().getPrice()-item.getBook().getDprice();
		Integer oldCount=item.getCount();
		item.setCount(count);
		//修改原本的总金额，节省金额——都清0
		total=total-oldCount*price;
		save=save-oldCount*dsave;
		//重新计算赋值
		total=total+count*price;
		save=save+count*dsave;
		session.setAttribute("cart", map);
		session.setAttribute("total", total);
		session.setAttribute("save",save);
	}

	@Override
	public void removeOneItem(String id) {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		HashMap<String,CartItem> map=(HashMap<String,CartItem>)session.getAttribute("cart");
		CartItem item=map.get(id);
		Integer count=item.getCount();
		Double oldTotal=(Double)session.getAttribute("total");
		Double oldSave=(Double)session.getAttribute("save");
		
		Double total=oldTotal-item.getBook().getDprice()*count;
		Double save=oldSave-(item.getBook().getPrice()-item.getBook().getDprice())*count;
		
		map.remove(id);
		if(map.size()==0){
			session.removeAttribute("cart");
			session.removeAttribute("total");
			session.removeAttribute("save");
		}else{
			session.setAttribute("cart", map);
			session.setAttribute("total", total);
			session.setAttribute("save",save);
		}
		
		
	}

}
