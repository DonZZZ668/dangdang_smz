package com.baizhi.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.OrderService;
import com.baizhi.util.DBUtil;

public class OrderServiceImpl implements OrderService {

	@Override
	public void addOneOrder(Address address) {
		// TODO Auto-generated method stub
		if(address.getLocal()==null || "".equals(address.getLocal())) throw new RuntimeException("地址不能为空");
		if(address.getName()==null || "".equals(address.getName())) throw new RuntimeException("收件人姓名不能为空");
		if(address.getZipCode()==null || "".equals(address.getZipCode())) throw new RuntimeException("邮编不能为空");
		if(address.getPhone()==null || "".equals(address.getPhone())) throw new RuntimeException("电话不能为空");
		AddressDao adao=(AddressDao)DBUtil.getDao(AddressDao.class);
		OrderDao odao=(OrderDao)DBUtil.getDao(OrderDao.class);
		BookDao bdao=(BookDao)DBUtil.getDao(BookDao.class);
		ItemDao idao=(ItemDao)DBUtil.getDao(ItemDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("loginUser");
		Double total=(Double)session.getAttribute("total");
		HashMap<String,CartItem> map=(HashMap<String,CartItem>)session.getAttribute("cart");
		try{
			if(address.getId()==null || "".equals(address.getId())){
				address.setId(UUID.randomUUID().toString());
				address.setCreateDate(new Date());
				address.setUserId(user.getId());
				adao.addOneAddress(address);
			}else{
				Address a=adao.queryByAddressId(address.getId());
				if(!a.equals(address)){
					adao.updateOneAddress(address);
				}
			}
			Order order=new Order(UUID.randomUUID().toString(),new Date().getTime()+"",total,new Date(),address.getId(),user.getId(),address.getName(),address.getLocal());
			odao.addOneOrder(order);
			
			Set<String> set=map.keySet();
			for(String id:set){
				CartItem cart=map.get(id);
				Book book=cart.getBook();
				Item item=new Item(UUID.randomUUID().toString(),order.getId(),book.getId(),cart.getCount(),new Date(),book.getName(),book.getCover(),book.getPrice(),book.getPrice());
				idao.addOneItem(item);
				
				book.setSale(book.getSale()+cart.getCount());
				book.setStock(book.getStock()-cart.getCount());
				bdao.updateBookSaleStock(book);
			}
			session.removeAttribute("cart");
			session.setAttribute("orderNum", order.getOrderNum());
			DBUtil.commit();
		}catch(Exception e){
			//e.printStackTrace();
			DBUtil.rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Order> queryAllOrder() {
		// TODO Auto-generated method stub
		OrderDao dao=(OrderDao)DBUtil.getDao(OrderDao.class);
		List<Order> list=dao.queryAllOrder();
		DBUtil.close();
		return list;
	}

	@Override
	public Order queryOneOrderMessage(String id) {
		// TODO Auto-generated method stub
		OrderDao dao=(OrderDao)DBUtil.getDao(OrderDao.class);
		Order o=dao.queryOneOrderMessage(id);
		DBUtil.close();
		return o;
	}

}
