package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.baizhi.util.DBUtil;

public class CategoryMapperTest {

	@Test
	public void testQueryAllCategory() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryAllCategory();
		for(Category c:list){
			System.out.println(list);
		}
		DBUtil.close();
	}
	@Test
	public void testAddFirst() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		String cateId=UUID.randomUUID().toString();
		Category cate=new Category(cateId,"测试一级类别",null,"1",null);
		dao.addFirst(cate);
		List<Category> list=dao.queryAllFirst();
		for(Category c:list){
			System.out.println(list);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryAllFirst() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryAllFirst();
		for(Category c:list){
			System.out.println(list);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryAllFirstService() {
		CategoryService service=new CategoryServiceImpl();
		List<Category> list=service.queryAllFirst();
		for(Category c:list){
			System.out.println(c);
		}
	}
	@Test
	public void testQueryById() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		Category c=dao.queryById("f0dbdcb6-1857-4063-8759-090265c217c1");
		System.out.println(c);
		DBUtil.close();
	}
	@Test
	public void testQuerySons() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.querySons("f0dbdcb6-1857-4063-8759-090265c217c5");
		for(Category c:list){
			System.out.println(list);
		}
		DBUtil.close();
	}
	
	@Test
	public void testQueryFirst() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list=dao.queryFirst();
		for(Category c:list){
			System.out.println(list);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryOneFirst() {
		CategoryDao dao=(CategoryDao)DBUtil.getDao(CategoryDao.class);
		Category c=dao.queryOneFirst("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1");
		System.out.println(c);
		DBUtil.close();
	}
}

