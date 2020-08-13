package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
	/**
	 * 这是后台管理员登录方法  shift+alt+j
	 * @param username  这是管理员输入的用户名
	 * @return  这是根据用户名查出的用户数据
	 */
	public Admin login(String username);
}
