package com.baizhi.action;

import com.baizhi.service.CartItemService;
import com.baizhi.service.impl.CartItemServiceImpl;

public class CartAction{
	private String id;
	private Integer count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String addCart(){
		CartItemService service=new CartItemServiceImpl();
		service.addCart(id);
		return "success";
	}
	public String updateCart(){
		CartItemService service=new CartItemServiceImpl();
		service.updateCart(id, count);
		return "success";
	}
	public String deleteOneItem(){
		CartItemService service=new CartItemServiceImpl();
		service.removeOneItem(id);
		return "success";
	}
}
