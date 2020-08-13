package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Order;
import com.baizhi.util.DBUtil;

public class OrderMapperTest {

	@Test
	public void testAdd() {
		OrderDao dao=(OrderDao)DBUtil.getDao(OrderDao.class);
		Order o=new Order("1","1",200.0,new Date(),"1","1","smz","山东菏泽");
		dao.addOneOrder(o);
		DBUtil.close();
	}
	@Test
	public void testqueryAll() {
		OrderDao dao=(OrderDao)DBUtil.getDao(OrderDao.class);
		List<Order> list=dao.queryAllOrder();
		for(Order o:list){
			System.out.println(o);
		}
		DBUtil.close();
	}
	@Test
	public void testquery() {
		OrderDao dao=(OrderDao)DBUtil.getDao(OrderDao.class);
		Order o=dao.queryOneOrderMessage("9ff7a546-0841-4ab6-b435-44953cdbea17");
		System.out.println(o);
		DBUtil.close();
	}

}
