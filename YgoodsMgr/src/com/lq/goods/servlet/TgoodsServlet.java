package com.lq.goods.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TgoodsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");
		resp.setContentType("text/html;charset=utf-8");
		if("list".equals(op))
		{
			list(req,resp);
		}else if("add".equals(op))
		{
			add(req,resp);
		}else if("del".equals(op))
		{
			del(req,resp);
		}else if("queryById".equals(op))
		{
			queryById(req,resp);
		}else if("update".equals(op))
		{
			update(req,resp);
		}else if("toUpdate".equals(op))
		{
			toUpdate(req,resp);
		}
	}
	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	private void queryById(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	private void del(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		
	}

}
