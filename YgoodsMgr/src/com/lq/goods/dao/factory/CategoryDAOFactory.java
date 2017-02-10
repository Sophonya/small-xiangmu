package com.lq.goods.dao.factory;

import java.util.List;

import com.lq.goods.dao.dao.CategoryDAO;
import com.lq.goods.dao.impl.CategoryDAOImpl;
import com.lq.goods.dao.vo.Category;

public class CategoryDAOFactory{
	public CategoryDAO getCategoryDAO()
	{
		return new CategoryDAOImpl();
	}
}

