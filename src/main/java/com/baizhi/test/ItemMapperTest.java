package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.util.DBUtil;

public class ItemMapperTest {

	@Test
	public void testAdd() {
		ItemDao dao=(ItemDao)DBUtil.getDao(ItemDao.class);
		Item item=new Item("1","1","1",3,new Date(),"1","1",100.0,90.0);
		dao.addOneItem(item);
		DBUtil.close();
	}

}
