package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	/**
	 * 查看所有类别信息的业务方法
	 * @return
	 */
	public List<Category> queryAllCategory();
	
	/**
	 * 添加一级类别
	 * @param cateName 添加的一级类别名称
	 */
	public void addFirst(String cateName);
	/**
	 * 添加二级类别的方法
	 * @param fid 传入的所属类别id
	 * @param sname 传入的二级类别名称
	 */
	public void addSecond(String fid,String sname);
	/**
	 * 查看所有的一级类别业务方法，用于添加二级类别的下拉菜单
	 * @return
	 */
	public List<Category> queryAllFirst();
	/**
	 * 根据id删除类别
	 * @param id 传入的类别id
	 */
	public void deleteOne(String id);
	/**
	 * 查看所有的二级类别
	 * @return
	 */
	public List<Category> queryAllSecond();
	/**
	 * 自连接展示一级类别包含的二级类别
	 * @return
	 */
	public List<Category> queryFirst();
	/**
	 * 根据ID自连接展示一个一级类别包含的二级类别
	 * @param id
	 * @return
	 */
	public Category queryOneFirst(String id);
}
