package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	/**
	 * 查询所有图书
	 * @return
	 */
	public List<Book> queryAll();
	/**
	 * 模糊查询
	 * @param key 根据什么查询
	 * @param countent 查询的内容
	 * @return
	 */
	public List<Book>queryByKey(@Param("key")String key,@Param("content")String countent);
	/**
	 * 添加一本图书
	 * @param book 收集到的book数据
	 */
	public void addOneBook(Book book);
	/**
	 * 根据图书id查询
	 * @param id 图书id
	 * @return
	 */
	public Book queryById(String id);
	/**
	 * 更新图书
	 * @param book
	 */
	public void updateOneBook(Book book);
	/**
	 * 根据图书id删除图书
	 * @param id 图书id
	 */
	public void deleteOneBook(String id);
	/**
	 * 查询全部图书(全部字段)
	 * @return
	 */
	public List<Book> queryAllField();
	/**
	 * 根据销量查询图书
	 * @return
	 */
	public List<Book> queryBySale();
	/**
	 * 根据上架时间查询
	 * @return
	 */
	public List<Book> queryByCreateDate();
	/**
	 * 根据上架时间和销量综合排序
	 * @return
	 */
	public List<Book> queryBySaleAndCreateDate();
	/**
	 * 查询二级页面图书
	 * @param fid 一级类别id
	 * @param sid 二级类别id
	 * @return
	 */
	public List<Book> querySecond(@Param("fid")String fid,@Param("sid")String sid);
	
	/**
	 * 分页查询
	 * @param fid 一级类别id
	 * @param sid 二级类别id
	 * @param begin 每页开始数
	 * @param end 每页结束数
	 * @return
	 */
	public List<Book> queryByPage(@Param("fid")String fid,@Param("sid")String sid,@Param("begin")Integer begin,@Param("end")Integer end);
	/**
	 * 查询总条目
	 * @param fid
	 * @param sid
	 * @return
	 */
	public Integer queryTotal(@Param("fid")String fid,@Param("sid")String sid);
	/**
	 * 修改图书的销量和库存
	 * @param book
	 */
	public void updateBookSaleStock(Book book);
}
