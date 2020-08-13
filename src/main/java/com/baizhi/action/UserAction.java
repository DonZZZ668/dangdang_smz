package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;

public class UserAction {
	public User user;
	public String email;
	public String password;
	public String code;
	public String message;
	public String activeCode;
	public List<User> ulist;
	
	public List<User> getUlist() {
		return ulist;
	}
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//获取注册验证码
	public String getRelCode(){
		String relcode=SecurityCode.getSecurityCode();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("relcode", relcode);
		BufferedImage image=SecurityImage.createImage(relcode);
		try {
			ImageIO.write(image, "png", ServletActionContext.getResponse().getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//用户登录
	public String login(){
		UserService service=new UserServiceImpl();
		try {
			service.login(email, password);
			return "loginSuccess";
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			message=e.getMessage();
			return "error";
		}
	}
	//用户注册
	public String regist(){
		UserService service=new UserServiceImpl();
		try {
			service.regist(user,code);
			return "registSuccess";
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			message=e.getMessage();
			return "error";
		}
	}
	//生成激活码
	public String getActiveCode(){
		activeCode=MD5Utils.getNum();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("activeCode", activeCode);
		return "success";
	}
	//激活用户
	public String activeUser(){
		UserService service=new UserServiceImpl();
		try{
			service.activeUser(code);
			return "success";
		}catch (Exception e) {
			// TODO: handle exception
			message=e.getMessage();
			return "error";
		}
	}
	//用户退出
	public String signOut(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginUser");
		return "success";
	}
	
	//后台展示用户数据
	public String queryAll(){
		UserService service=new UserServiceImpl();
		ulist=service.queryAll();
		return "success";
	}
	//修改用户状态
	public String updateStatus(){
		UserService service=new UserServiceImpl();
		service.updateStatus(email);
		return "success";
	}
}
