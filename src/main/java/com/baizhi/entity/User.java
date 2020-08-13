package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private String id;
	private String email;
	private String password;
	private String nickname;
	private String status="未激活";
	private String code;
	private Date createDate;
	private String salt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", nickname=" + nickname + ", status=" + status + ", code="
				+ code + ", createDate=" + createDate + ", salt=" + salt + "]";
	}
	public User(String id, String email, String password, String nickname,
			String status, String code, Date createDate, String salt) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.createDate = createDate;
		this.salt = salt;
	}
	public User() {
		super();
	}
	public User(String id, String email, String password, String nickname,
			String code, Date createDate, String salt) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.code = code;
		this.createDate = createDate;
		this.salt = salt;
	}
	
	
}
