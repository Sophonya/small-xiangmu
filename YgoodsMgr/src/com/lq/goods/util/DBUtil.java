package com.lq.goods.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//1.加载数据库驱动
//2.


public class DBUtil {//sql---->com.lq.course.util
	static{
		try {//加载数据库启动
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection openConn() throws SQLException
	{//获得数据库的连接
		return DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", 
									"scott", "tiger");
	}

}
