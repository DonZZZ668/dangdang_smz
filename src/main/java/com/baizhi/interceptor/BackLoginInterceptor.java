package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BackLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		Admin admin=(Admin)session.getAttribute("loginAdmin");
		if(admin==null){
			return "login";
		}else{
			arg0.invoke();
		}
		return null;
	}

}
