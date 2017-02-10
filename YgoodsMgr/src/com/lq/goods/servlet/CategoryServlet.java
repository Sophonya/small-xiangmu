package com.lq.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lq.goods.biz.CategoryBiz;
import com.lq.goods.dao.impl.CategoryDAOImpl;
import com.lq.goods.dao.vo.Category;

public class CategoryServlet extends HttpServlet {
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
	private CategoryBiz cb=new CategoryBiz();
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Category g = new Category();
		    g.setId(Integer.parseInt(req.getParameter("id")));
		    g.setName(req.getParameter("name"));
		    g.setMark(req.getParameter("mark"));
		    CategoryBiz bdao = new CategoryBiz();
		    boolean b = bdao.update(g);
		    if(b)
		    {
		    	PrintWriter out = resp.getWriter();
				out.println("<script type='text/javascript'>"
						+ "alert('更新用户成功！！');"
						+ "window.location='CategoryServlet?op=list';" 
						+ "</script>");
			}else{
				PrintWriter out = resp.getWriter();
				out.println("<script type='text/javascript'>"
						+ "alert('更新用户失败！！');" + "window.history.back();"
						+ "</script>");
			}
		
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> clist=cb.queryAll();
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("list.jsp")
			.forward(req, resp);
	}
		
	
	private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		 System.out.println(id);
		 CategoryDAOImpl cdao = new CategoryDAOImpl();
		if(id!=-1)
		{
			cdao.del(id);
			resp.sendRedirect("CategoryServlet?op=list");
		}else{
			PrintWriter out = resp.getWriter();
			out.println("<script type='text/javascript'>"
					+ "alert('此用户不存在~~~！！');" + "window.history.back();"
					+ "</script>");
		}
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Category c = new Category();
		c.setName(req.getParameter("name"));
		c.setMark(req.getParameter("mark"));
		boolean b = cb.add(c);
		if(b)
		{
			PrintWriter out = resp.getWriter();
			out.println("<script type='text/javascript'>"
					+ "alert('添加商品类别成功！！');"
					+ "window.location='CategoryServlet?op=list';" 
					+ "</script>");
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<script type='text/javascript'>"
					+ "alert('添加商品类别失败！！');" + "window.history.back();"
					+ "</script>");
		}
		}
		
	private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String id=req.getParameter("id");
		Category c=cb.queryById(Integer.parseInt(id));
		if(c!=null)
		{//{suc:true,factory:'xxx',price:xxx}
			out.print("{suc:true,factory:\""
							+c.getName()+"\",price:"+c.getMark()+"}");
		}else{
			out.print("{suc:false}");
		}
		
	}
	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		Category c = cb.queryById(id);
		if(c!=null)
		{
		 req.setAttribute("c", c);
		 req.getRequestDispatcher("update.jsp")
		 .forward(req, resp);
		 
		}else{
			PrintWriter out = resp.getWriter();
			out.println("<script type='text/javascript'>"
					+ "alert('此用户不存在~~~！！');" + "window.history.back();"
					+ "</script>");
		}
	}
	

}
