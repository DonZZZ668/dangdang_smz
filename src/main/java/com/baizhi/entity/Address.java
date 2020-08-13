package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable{
	private String id;
	private String name;
	private String phone;
	private String local;
	private String zipCode;
	private Date createDate;
	private String userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", local=" + local + ", zipCode=" + zipCode + ", createDate="
				+ createDate + ", userId=" + userId + "]";
	}
	public Address(String id, String name, String phone, String local,
			String zipCode, Date createDate, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.local = local;
		this.zipCode = zipCode;
		this.createDate = createDate;
		this.userId = userId;
	}
	public Address() {
		super();
	}
	
}
