package com.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String methodName = req.getParameter("method");
		if(methodName == null || methodName.isEmpty()) {
			methodName = "execute";
		}
		Class c = this.getClass();
		try {
			Method m = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			String result = (String) m.invoke(this, req,resp);
			if(result != null && !result.isEmpty()) {
				req.getRequestDispatcher(result).forward(req, resp);
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	} 
}
