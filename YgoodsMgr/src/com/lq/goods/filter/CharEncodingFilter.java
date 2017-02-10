package com.lq.goods.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharEncodingFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
	}

	private String encoding="utf-8";
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg0.setCharacterEncoding(encoding);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String str=arg0.getInitParameter("encoding");//可能配置|没陪
		if(str!=null)
		{//用户配置了，使用用户配置的
			encoding=str;
		}
	}



}