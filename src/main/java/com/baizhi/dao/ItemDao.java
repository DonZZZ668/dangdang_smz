package com.baizhi.dao;

import com.baizhi.entity.Item;

public interface ItemDao {
	/**
	 * 添加订单项信息
	 * @param item
	 */
	public void addOneItem(Item item);
}
