package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDao {
	/**
	 * 根据邮箱查询是否有此用户
	 * @param email
	 * @return
	 */
	public User queryOneByEmail(String email);
	/**
	 * 注册新用户
	 * @param user
	 */
	public void insertOne(User user);
	/**
	 * 修改用户状态
	 * @param user
	 */
	public void activeUser(User user);
	/**
	 * 查询所有用户数据
	 * @return
	 */
	public List<User> queryAll();
	/**
	 * 修改用户状态
	 * @param user
	 */
	public void updateStatus(User user);
}
