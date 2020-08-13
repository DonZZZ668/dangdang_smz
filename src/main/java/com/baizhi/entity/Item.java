package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable{
	private String id;
	private String orderId;
	private String bookId;
	private Integer count;
	private Date createDate;
	private String name;
	private String cover;
	private Double price;
	private Double dprice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", orderId=" + orderId + ", bookId=" + bookId
				+ ", count=" + count + ", createDate=" + createDate + ", name="
				+ name + ", cover=" + cover + ", price=" + price + ", dprice="
				+ dprice + "]";
	}
	public Item(String id, String orderId, String bookId, Integer count,
			Date createDate, String name, String cover, Double price,
			Double dprice) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.count = count;
		this.createDate = createDate;
		this.name = name;
		this.cover = cover;
		this.price = price;
		this.dprice = dprice;
	}
	public Item() {
		super();
	}
	
	
}
