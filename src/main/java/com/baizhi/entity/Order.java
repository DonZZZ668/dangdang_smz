package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	private String id;
	private String orderNum;
	private Double total;
	private Date createDate;
	private String addressId;
	private String userId;
	private String name;
	private String local;
	private List<Item> items;
	
	public Order(String id, String orderNum, Double total, Date createDate,
			String addressId, String userId, String name, String local,
			List<Item> items) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.total = total;
		this.createDate = createDate;
		this.addressId = addressId;
		this.userId = userId;
		this.name = name;
		this.local = local;
		this.items = items;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNum=" + orderNum + ", total="
				+ total + ", createDate=" + createDate + ", addressId="
				+ addressId + ", userId=" + userId + ", name=" + name
				+ ", local=" + local + ", items=" + items + "]";
	}
	public Order(String id, String orderNum, Double total, Date createDate,
			String addressId, String userId, String name, String local) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.total = total;
		this.createDate = createDate;
		this.addressId = addressId;
		this.userId = userId;
		this.name = name;
		this.local = local;
	}
	public Order() {
		super();
	}
	
}
