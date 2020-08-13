package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	/**
	 * 注册
	 * @param user
	 * @param code 验证码
	 */
	public void regist(User user,String code);
	/**
	 * 激活用户
	 * @param code
	 */
	public void activeUser(String code);
	/**
	 * 登录
	 * @param email
	 * @param password
	 */
	public void login(String email,String password);
	/**
	 * 查询所有用户数据
	 * @return
	 */
	public List<User> queryAll();
	
	/**
	 * 修改用户状态
	 * @param id
	 */
	public void updateStatus(String email);
}
