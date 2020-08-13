package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private String id;
	private String name;
	private String parentId;
	private String levels;
	//关系属性
	private Category father;
	
	private List<Category> sons;
	public List<Category> getSons() {
		return sons;
	}
	public void setSons(List<Category> sons) {
		this.sons = sons;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category getFather() {
		return father;
	}
	public void setFather(Category father) {
		this.father = father;
	}

	public Category(String id, String name, String parentId, String levels,
			Category father) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
		this.father = father;
	}
	public Category(String id, String name, String parentId, String levels,
			Category father, List<Category> sons) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
		this.father = father;
		this.sons = sons;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", levels=" + levels + ", father=" + father
				+ ", sons=" + sons + "]";
	}
	public Category() {
		super();
	}
	
}
