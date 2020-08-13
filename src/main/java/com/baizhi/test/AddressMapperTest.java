package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Admin;
import com.baizhi.util.DBUtil;

public class AddressMapperTest {

	@Test
	public void testQueryByUserId() {
		AddressDao dao=(AddressDao)DBUtil.getDao(AddressDao.class);
		List<Address> list=dao.queryByUserId("1");
		for(Address a:list){
			System.out.println(a);
		}
		
		DBUtil.close();
	}
	@Test
	public void testQueryByAddressId() {
		AddressDao dao=(AddressDao)DBUtil.getDao(AddressDao.class);
		Address a=dao.queryByAddressId("1");
		System.out.println(a);
		
		DBUtil.close();
	}

	@Test
	public void testAdd() {
		AddressDao dao=(AddressDao)DBUtil.getDao(AddressDao.class);
		Address a=new Address(UUID.randomUUID().toString(),"123","123456","山东菏泽","123456",new Date(),"1");
		dao.updateOneAddress(a);
		List<Address> list=dao.queryByUserId("1");
		for(Address b:list){
			System.out.println(b);
		}
		
		DBUtil.close();
	}
}
