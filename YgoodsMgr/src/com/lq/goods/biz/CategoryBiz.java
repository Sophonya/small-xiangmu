package com.lq.goods.biz;

import java.util.List;

import com.lq.goods.dao.dao.CategoryDAO;
import com.lq.goods.dao.factory.CategoryDAOFactory;
import com.lq.goods.dao.vo.Category;

public class CategoryBiz {
	private CategoryDAO cdao = new CategoryDAOFactory().getCategoryDAO();
	public List<Category> queryAll(){
		return cdao.queryAll();
	}
	public Category queryById(int id){
		return cdao.queryById(id);
	}
	public boolean del(int id)
	{
		return cdao.del(id);
	}
	public boolean add(Category c)
	{
		return cdao.add(c);
	}
	public boolean update(Category c)
	{
		return cdao.update(c);
	}

}
