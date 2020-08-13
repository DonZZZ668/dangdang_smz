package com.baizhi.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.BookDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.util.DBUtil;

public class BookMapperTest {

//	@Test
//	public void testQueryAll() {
//		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
//		List<Book> list=dao.queryAll();
//		for(Book b:list){
//			System.out.println(b);
//		}
//		DBUtil.close();
//	}
	@Test
	public void testQueryByKeY() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByKey("press", "百知");
		for(Book b:list){
			System.out.println(b);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryById() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		Book b=dao.queryById("1");
		System.out.println(b);
		DBUtil.close();
	}
	@Test
	public void testQueryAllField() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryAllField();
		for(Book b:list){
			System.out.println(b);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryBySale() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryBySale();
		for(Book b:list){
			System.out.println(b);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryByCreateDate() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByCreateDate();
		for(Book b:list){
			System.out.println(b);
		}
		DBUtil.close();
	}
	@Test
	public void testQueryBySaleAndCreateDate() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryBySaleAndCreateDate();
		for(Book b:list){
			System.out.println(b);
		}
		DBUtil.close();
	}
	@Test
	public void testQuerySecond() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.querySecond("e3b519c5-e9ef-4d09-972e-ae03439476fd", "1ad9fd7b-54d3-49b7-b164-af191c6ded35");
		for(Book b:list){
			System.out.println(b);
			
		}
		System.out.println(list.size());
		DBUtil.close();
	}
	@Test
	public void testQueryByPage() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByPage("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1", null,1,4);
		for(Book b:list){
			System.out.println(b);
			
		}
		System.out.println(list.size());
		DBUtil.close();
	}
	
	@Test
	public void testQueryTotal() {
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		Integer i=dao.queryTotal("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1","f0dbdcb6-1857-4063-8759-090265c217c3");
		
		System.out.println(i);
		DBUtil.close();
	}
}
