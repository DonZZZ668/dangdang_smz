package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;


public interface OrderService {

	/**
	 * 添加订单
	 * @param order
	 */
	public void addOneOrder(Address address);
	/**
	 * 后台查询所有订单
	 * @return
	 */
	public List<Order> queryAllOrder();
	/**
	 * 查询订单包含的具体订单项
	 * @param id
	 * @return
	 */
	public Order queryOneOrderMessage(String id);
	
}
