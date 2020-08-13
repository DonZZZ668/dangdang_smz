package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.OrderServiceImpl;

public class OrderAction {
	private Address address;
	private List<Order> olist;
	private Order order;
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Order> getOlist() {
		return olist;
	}

	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public String addOrder(){
		OrderService service=new OrderServiceImpl();
		service.addOneOrder(address);
		return "success";
	}
	public String queryAll(){
		OrderService service=new OrderServiceImpl();
		olist=service.queryAllOrder();
		return "success";
	}
	public String queryOneOrderMessage(){
		OrderService service=new OrderServiceImpl();
		order=service.queryOneOrderMessage(id);
		return "success";
	}
}
