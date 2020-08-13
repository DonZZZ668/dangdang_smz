package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.DBUtil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> queryAll() {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryAll();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> queryByKey(String key, String content) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByKey(key,content);
		DBUtil.close();
		return list;
	}

	@Override
	public boolean addOneBook(Book b) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		b.setId(UUID.randomUUID().toString());
		b.setCreateDate(new Date());
		b.setSale(0);
		//System.out.println(b);
		try {
			dao.addOneBook(b);
			DBUtil.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			DBUtil.rollback();
			//e.printStackTrace();
			return false;
		}
	}

	@Override
	public Book queryById(String id) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		Book b=dao.queryById(id);
		DBUtil.close();
		return b;
	}

	@Override
	public void updateOneBook(Book b) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		try {
			dao.updateOneBook(b);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DBUtil.rollback();
			//e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOneBook(String id) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		try {
			dao.deleteOneBook(id);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DBUtil.rollback();
			//e.printStackTrace();
		}
	}

	@Override
	public List<Book> queryRecommend() {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryAllField();
		Integer a=new Random().nextInt(list.size());
		Integer b=new Random().nextInt(list.size());
		while(true){
			if(a==b){
				b=new Random().nextInt(list.size());
			}else{
				break;
			}
		}
		List<Book> list2=new ArrayList<>();
		list2.add(list.get(a));
		list2.add(list.get(b));
		DBUtil.close();
		return list2;
	}

	@Override
	public List<Book> queryHots() {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryBySale();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> queryNews() {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByCreateDate();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> queryNewAndHot() {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryBySaleAndCreateDate();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> querySecond(String fid, String sid) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.querySecond(fid, sid);
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> querySecondByPage(String fid, String sid,
			Integer pageSize, Integer pageNum) {
		// TODO Auto-generated method stub
		int begin=pageSize*(pageNum-1)+1;
		int end=pageSize*pageNum;
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		List<Book> list=dao.queryByPage(fid, sid,begin,end);
		DBUtil.close();
		return list;
	}

	@Override
	public Integer queryCount(String fid, String sid, Integer pageSize) {
		// TODO Auto-generated method stub
		BookDao dao=(BookDao)DBUtil.getDao(BookDao.class);
		Integer total=dao.queryTotal(fid, sid);
		Integer count=(total%pageSize==0)?(total/pageSize):(total/pageSize+1);
		
		return count;
	}

}
