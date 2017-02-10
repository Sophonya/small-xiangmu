package com.lq.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lq.goods.dao.dao.TgoodsDAO;
import com.lq.goods.dao.vo.Category;
import com.lq.goods.dao.vo.Tgoods;
import com.lq.goods.util.DBUtil;

public class TgoodsDAOImpl implements TgoodsDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;

	@Override
	public List<Tgoods> queryAll() {
List<Tgoods> tlist = new ArrayList<Tgoods>();
		
		sql = "select * from tgoods";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				
			Tgoods t = new Tgoods();
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setPrice(rs.getInt("price"));
			t.setNum(rs.getInt("num"));
			tlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}

	@Override
	public Tgoods queryById(int id) {
		sql = "select *　from tgoods where id = ?";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				Tgoods t = new Tgoods();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setPrice(rs.getInt("price"));
				t.setNum(rs.getInt("num"));
				return t;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean del(int id) {
		sql="delete from tgoods where id = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean add(Tgoods t) {
		sql = "insert into tgoods values (null,?,?,?,?)";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setInt(2, t.getPrice());
			pst.setInt(3, t.getNum());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Tgoods t) {
		sql = "update tgoods set name=?,price=?,num=? where id=?";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setInt(2, t.getPrice());
			pst.setInt(3, t.getCid());
			pst.setInt(4, t.getNum());
			pst.setInt(5, t.getId());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
