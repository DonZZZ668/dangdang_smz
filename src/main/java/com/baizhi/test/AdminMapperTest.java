package com.baizhi.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.DBUtil;

public class AdminMapperTest {

	@Test
	public void testLogin() {
		AdminDao dao=(AdminDao)DBUtil.getDao(AdminDao.class);
		Admin a=dao.login("admin");
		System.out.println(a);
		DBUtil.close();
	}

}
