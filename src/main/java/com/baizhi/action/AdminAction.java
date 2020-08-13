package com.baizhi.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.service.AdminService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private String username;
	private String password;
	private String message;
	private String code;
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//管理员登录
	public String login(){
		AdminService service=new AdminServiceImpl();
		try {
			service.login(username, password,code);
			return "loginSuccess";
		} catch (Exception e) {
			// TODO: handle exception
			message=e.getMessage();
			return "error";
		}
	}
	//获取验证码
	public String getCode(){
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
	//管理员退出
	public String signOut(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginAdmin");
		return "outSuccess";
	}
	
}
