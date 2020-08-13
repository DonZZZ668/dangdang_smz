package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order
	 */
	public void addOneOrder(Order order);
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
