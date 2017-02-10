package com.lq.goods.dao.factory;

import com.lq.goods.dao.dao.TgoodsDAO;
import com.lq.goods.dao.impl.TgoodsDAOImpl;

public class TgoodsDAOFactory {
	public TgoodsDAO getTgoodsDAO()
	{
		return new TgoodsDAOImpl();
	}

}
