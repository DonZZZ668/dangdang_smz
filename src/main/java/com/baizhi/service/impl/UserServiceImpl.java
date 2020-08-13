package com.baizhi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.DBUtil;
import com.baizhi.util.MD5Utils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user, String code) {
		// TODO Auto-generated method stub
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		String relcode=(String)session.getAttribute("relcode");
		if(!relcode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误");
		try{
			User u=dao.queryOneByEmail(user.getEmail());
			if(u!=null)throw new RuntimeException("该邮箱已经被注册");
			//对明文密码进行加密
			String salt=MD5Utils.getSalt();
			String password=MD5Utils.getPassword("123456"+salt);
			//补全用户数据
			user.setId(UUID.randomUUID().toString());
			user.setSalt(salt);
			user.setPassword(password);
			user.setCreateDate(new Date());
			dao.insertOne(user);
			session.setAttribute("loginUser", user);
			DBUtil.commit();
		}catch(Exception e){
			//e.printStackTrace();
			DBUtil.rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void activeUser(String code) {
		// TODO Auto-generated method stub
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("loginUser");
		String activeCode=(String)session.getAttribute("activeCode");
		if(!activeCode.equals(code))throw new RuntimeException("激活码输入错误");
		user.setCode(code);
		user.setStatus("已激活");
		try{
			dao.activeUser(user);
			session.setAttribute("loginUser", user);
			DBUtil.commit();
		}catch(Exception e){
			//e.printStackTrace();
			DBUtil.rollback();
		}
	}

	@Override
	public void login(String email, String password) {
		// TODO Auto-generated method stub
		if(email==null || email.equals(""))throw new RuntimeException("邮箱为空！");
		if(password==null || password.equals(""))throw new RuntimeException("密码为空！");
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u=dao.queryOneByEmail(email);
		try{
			if(u==null)throw new RuntimeException("eamil输入错误");
			//校验密码是否输入正确
			String pass=MD5Utils.getPassword(password+u.getSalt());
			if(!pass.equals(u.getPassword()))throw new RuntimeException("密码错误");
			if("冻结".equals(u.getStatus()))throw new RuntimeException("用户已被冻结");
			session.setAttribute("loginUser", u);
		}catch(Exception e){
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		DBUtil.close();
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		List<User> list=dao.queryAll();
		DBUtil.close();
		return list;
	}

	@Override
	public void updateStatus(String email) {
		// TODO Auto-generated method stub
		UserDao dao=(UserDao)DBUtil.getDao(UserDao.class);
		User u=dao.queryOneByEmail(email);
		if(u.getStatus().equals("冻结")){
			if(u.getCode()!=null){
				u.setStatus("已激活");
			}else{
				u.setStatus("未激活");
			}
		}else{
			u.setStatus("冻结");
		}
		try{
			dao.updateStatus(u);
			DBUtil.commit();
		}catch(Exception e){
			//e.printStackTrace();
			DBUtil.rollback();
		}
	}
}
