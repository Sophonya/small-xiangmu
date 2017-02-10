package com.lq.goods.dao.dao;

import java.util.List;

import com.lq.goods.dao.vo.Category;
import com.lq.goods.dao.vo.Tgoods;

public interface TgoodsDAO {
	public List<Tgoods> queryAll();
	public Tgoods queryById(int id);
	boolean del(int id);
	public boolean add(Tgoods t);
	public boolean update(Tgoods t);

}
