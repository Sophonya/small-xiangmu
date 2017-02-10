package com.lq.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lq.goods.dao.dao.CategoryDAO;
import com.lq.goods.dao.vo.Category;
import com.lq.goods.util.DBUtil;

public class CategoryDAOImpl implements CategoryDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;

	@Override
	public List<Category> queryAll() {
List<Category> clist = new ArrayList<Category>();
		
		sql = "select * from categoryyc";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setMark(rs.getString("mark"));
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public Category queryById(int id) {
		sql = "select *　from categoryyc where id = ?";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setMark(rs.getString("mark"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean del(int id) {
		sql="delete from categoryyc where id = ?";
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
	public boolean add(Category c) {
		sql = "insert into categoryyc values (null,?,?)";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getMark());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public boolean update(Category c) {
		sql = "update categoryyc set name=?,mark=? where id=?";
		try {
			conn = DBUtil.openConn();
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getMark());
			pst.setInt(3, c.getId());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
