package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FrontInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u=(User)session.getAttribute("loginUser");
		if(u==null){
			return "login";
		}else{
			if(u.getCode()==null || "".equals(u.getCode())){
				return "active";
			}else{
				arg0.invoke();
			}
		}
		return null;
	}

}
