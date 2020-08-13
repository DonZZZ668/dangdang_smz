package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	private List<Category> list;
	private String firstName;
	private String fid;
	private String sname;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}
	
	public String queryAllCategory(){
		CategoryService service=new CategoryServiceImpl();
		list=service.queryAllCategory();
		return "success";
	}
	public String addFirst(){
		CategoryService service=new CategoryServiceImpl();
		service.addFirst(firstName);
		return "success";
	}
	public String queryAllFirst(){
		CategoryService service=new CategoryServiceImpl();
		list=service.queryAllFirst();
		return "success";
	}
	public String addSecond(){
		CategoryService service=new CategoryServiceImpl();
		service.addSecond(fid, sname);
		return "success";
	}
	public String deleteOne(){
		CategoryService service=new CategoryServiceImpl();
		service.deleteOne(fid);
		return "success";
	}
	public String queryAllSecond(){
		CategoryService service=new CategoryServiceImpl();
		list=service.queryAllSecond();
		return "success";
	}
}
