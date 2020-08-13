package com.baizhi.service;



public interface CartItemService {
	public void addCart(String id);
	public void updateCart(String id,Integer count);
	public void removeOneItem(String id);
}
