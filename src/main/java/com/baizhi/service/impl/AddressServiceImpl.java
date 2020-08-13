package com.baizhi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.util.DBUtil;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> queryByUserId() {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("loginUser");
		AddressDao dao=(AddressDao)DBUtil.getDao(AddressDao.class);
		List<Address> list=dao.queryByUserId(user.getId());
		DBUtil.close();
		return list;
	}

	@Override
	public Address queryByAddressId(String id) {
		// TODO Auto-generated method stub
		AddressDao dao=(AddressDao)DBUtil.getDao(AddressDao.class);
		Address a=dao.queryByAddressId(id);
		DBUtil.close();
		return a;
	}

}
