package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.DBUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> queryAllCategory() {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryAllCategory();
		DBUtil.close();
		return list;
	}

	@Override
	public void addFirst(String cateName) {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		if(cateName==null || cateName.replace(" ", "").equals("") || cateName.equals(""))return;
		try {
			List<Category> list=dao.queryAllFirst();
			for(Category c:list){
				if(cateName.equals(c.getName()))return;
			}
			String cateId=UUID.randomUUID().toString();
			Category cate=new Category(cateId,cateName,null,"1",null);
			dao.addFirst(cate);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DBUtil.rollback();
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void addSecond(String fid, String sname) {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		if(sname==null || sname.replace(" ", "").equals("") || sname.equals(""))return;
		try {
			List<Category> list=dao.queryAllSecond();
			for(Category c:list){
				if(sname.equals(c.getName()))return;
			}
			Category cate=dao.queryById(fid);
			String cateId=UUID.randomUUID().toString();
			Category cate2=new Category(cateId,sname,fid,"2",cate);
			dao.addSecond(cate2);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DBUtil.rollback();
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Category> queryAllFirst() {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryAllFirst();
		DBUtil.close();
		return list;
	}

	@Override
	public void deleteOne(String id) {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		try {
			List<Category> list=dao.querySons(id);
			if(list.size()==0){
				dao.deleteOne(id);
				DBUtil.commit();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			DBUtil.rollback();
			//e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Category> queryAllSecond() {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryAllSecond();
		return list;
	}

	@Override
	public List<Category> queryFirst() {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryFirst();
		DBUtil.close();
		return list;
	}

	@Override
	public Category queryOneFirst(String id) {
		// TODO Auto-generated method stub
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		Category c=dao.queryOneFirst(id);
		DBUtil.close();
		return c;
	}

}
