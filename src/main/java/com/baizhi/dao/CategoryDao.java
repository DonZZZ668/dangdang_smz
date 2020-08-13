package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryDao {
	/**
	 * 查询所有的类别信息
	 * @return
	 */
	public List<Category> queryAllCategory();
	/**
	 * 添加一级类别
	 * @param cate 传入一个添加的一级类别
	 */
	public void addFirst(Category cate);
	/**
	 * 查看所有的一级类别名称
	 * @return
	 */
	public List<Category> queryAllFirst();
	/**
	 * 添加二级类别
	 * @param cate 传入一个添加的二级类别
	 */
	public void addSecond(Category cate);
	/**
	 * 查看所有的二级类别名称
	 * @return
	 */
	public List<Category> queryAllSecond();
	/**
	 * 根据id查询类别
	 * @param id 传入的类别id
	 * @return
	 */
	public Category queryById(String id);
	/**
	 * 查看当前类别是一级类别低下是否管理着二级类别
	 * @param id 传入的类别id
	 * @return
	 */
	public List<Category> querySons(String id);
	/**
	 * 根据id删除类别
	 * @param id 传入的类别id
	 */
	public void deleteOne(String id);
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
