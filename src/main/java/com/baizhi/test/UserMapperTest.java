package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.util.DBUtil;
import com.baizhi.util.MD5Utils;

public class UserMapperTest {

	@Test
	public void testQueryOneByEmali() {
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		User user=dao.queryOneByEmail("455930668@qq.com");
		System.out.println(user);
		DBUtil.close();
	}
	@Test
	public void testInsertOne() {
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		String id=UUID.randomUUID().toString();
		String email="455930668@qq.com";
		String nickname="smz";
		String code=MD5Utils.getNum();
		String salt=MD5Utils.getSalt();
		String password=MD5Utils.getPassword("123456"+salt);
		User u=new User(id,email,password,nickname,code,new Date(),salt);
		dao.insertOne(u);
		User user=dao.queryOneByEmail("455930668@qq.com");
		System.out.println(user);
		DBUtil.commit();
	}
	@Test
	public void testUpdate() {
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		User user=dao.queryOneByEmail("455930668@qq.com");
		user.setCode("smz");
		dao.activeUser(user);
		User u=dao.queryOneByEmail("455930668@qq.com");
		System.out.println(u);
		DBUtil.close();
	}
	@Test
	public void testQueryAll() {
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		List<User> list=dao.queryAll();
		for(User u:list){
			System.out.println(u);
		}
		DBUtil.close();
	}

}
