package com.baizhi.service;

public interface AdminService {
	/**
	 * 这是后台管理员登录的业务方法
	 * @param username
	 * @param password
	 */
	public void login(String username,String password,String code);
}
