package com.lq.goods.dao.dao;

import java.util.List;

import com.lq.goods.dao.vo.Category;

public interface CategoryDAO {
	public List<Category> queryAll();
	public Category queryById(int id);
	boolean del(int id);
	public boolean add(Category c);
	public boolean update(Category c);

}
