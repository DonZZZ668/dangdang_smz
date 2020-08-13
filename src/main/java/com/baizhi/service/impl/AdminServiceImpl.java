package com.baizhi.service.impl;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.DBUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public void login(String username, String password,String code) {
		// TODO Auto-generated method stub
		AdminDao dao=(AdminDao)DBUtil.getDao(AdminDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			if(username==null || username.equals(""))throw new RuntimeException("用户名为空！");
			if(password==null || password.equals(""))throw new RuntimeException("密码为空！");
			if(code==null || code.equals(""))throw new RuntimeException("验证码为空！");
			String relCode=(String)session.getAttribute("relcode");
			//System.out.println(code+"\t"+relCode);
			if(!code.equalsIgnoreCase(relCode))throw new RuntimeException("验证码错误！");
			Admin a=dao.login(username);
			if(a==null)throw new RuntimeException("用户名输入错误!");
			if(!a.getPassword().equals(password))throw new RuntimeException("密码输入错误！");
			session.removeAttribute("relcode");
			session.setAttribute("loginAdmin", a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			DBUtil.close();
		}
	}

}
