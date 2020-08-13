package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

/**
 * @author abc
 *
 */
public interface BookService {
	/**
	 * 业务层展示所有图书
	 * @return
	 */
	public List<Book> queryAll();
	/**
	 * 模糊查询
	 * @param key 根据什么查询
	 * @param countent 查询的内容
	 * @return
	 */
	public List<Book> queryByKey(String key,String content);
	/**
	 * 添加一本图书
	 * @param b 网页收集到的book对象
	 */
	public boolean addOneBook(Book b);
	/**
	 * 根据id查询图书
	 * @param id 传入的图书id
	 * @return
	 */
	public Book queryById(String id);
	
	/**
	 * 更新图书
	 * @return
	 */
	public void updateOneBook(Book b);
	/**
	 * 根据图书id删除图书
	 * @param id 图书id
	 */
	public void deleteOneBook(String id);
	/**
	 * 编辑推荐图书
	 * @return
	 */
	public List<Book> queryRecommend();
	/**
	 * 热卖图书推荐
	 * @return
	 */
	public List<Book> queryHots();
	/**
	 * 最新上架图书推荐
	 * @return
	 */
	public List<Book> queryNews();
	/**
	 * 新手热卖榜
	 * @return
	 */
	public List<Book> queryNewAndHot();
	/**
	 * 查询二级页面图书
	 * @param fid 一级类别id
	 * @param sid 二级类别id
	 * @return
	 */
	public List<Book> querySecond(String fid,String sid);
	
	/**
	 * 带分页的查询二级页面
	 * @param fid
	 * @param sid
	 * @param pageSize 每页展示多少图书
	 * @param pageNum 页码
	 * @return
	 */
	public List<Book> querySecondByPage(String fid,String sid,Integer pageSize,Integer pageNum);
	
	/**
	 * 查询总共多少页
	 * @param fid
	 * @param sid
	 * @param pageSize
	 * @return
	 */
	public Integer queryCount(String fid,String sid,Integer pageSize);
}
