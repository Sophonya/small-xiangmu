package com.lq.goods.biz;

import java.util.List;

import com.lq.goods.dao.dao.TgoodsDAO;
import com.lq.goods.dao.factory.TgoodsDAOFactory;
import com.lq.goods.dao.vo.Category;
import com.lq.goods.dao.vo.Tgoods;

public class TgoodsBiz {
	private TgoodsDAO tdao = new TgoodsDAOFactory().getTgoodsDAO();
	public List<Tgoods> queryAll(){
		return tdao.queryAll();
	}
	public Tgoods queryById(int id){
		return tdao.queryById(id);
	}
	public boolean del(int id)
	{
		return tdao.del(id);
	}
	public boolean add(Tgoods t)
	{
		return tdao.add(t);
	}
	public boolean update(Tgoods t)
	{
		return tdao.update(t);
	}

}
