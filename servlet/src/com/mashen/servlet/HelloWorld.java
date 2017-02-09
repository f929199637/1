package com.mashen.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloWorld implements Servlet {

	@Override
	public void destroy() {
		System.out.println("servlet被销毁");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("servlet初始化");

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet提供服务");
		
		//String name=request.getParameter("name");
		//System.out.println(name);
		/*String[] strs=request.getParameterValues("name");
		for(String str:strs){
			System.out.println(str);
		}*/
		
		//response.getWriter().println("servlet running");
		
		/*HttpServletResponse httpRes=(HttpServletResponse)response;
		httpRes.sendRedirect("http://www.baidu.com");//客户端跳转*/
		
		HttpServletRequest httpReq=(HttpServletRequest)request;
		httpReq.getRequestDispatcher("/hello2").forward(httpReq, response);//服务端跳转
		
		}

}
