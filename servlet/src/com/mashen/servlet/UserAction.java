package com.mashen.servlet;

import com.mashen.user.domain.UserDao;
import com.mashen.user.domain.User;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet("/user")
@WebServlet(urlPatterns={"/user1","/user2"},loadOnStartup=1)
@MultipartConfig(location="d:/apps")
public class UserAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAction() {
		System.out.println("UserAction被实例化");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("Service方法被调用");
//		if ("GET".equals(req.getMethod())) {
//			this.doGet(req, resp);
//		} else {
//			this.doPost(req, resp);
//		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//resp.getWriter().println("doget");
		String id=req.getParameter("id");
		if(id!=null){
		UserDao userDao = new UserDao(); 
		User user=new User();
		user=userDao.get(Integer.parseInt(id));
		req.getSession().setAttribute("user", user);}
		resp.sendRedirect(req.getContextPath()+"/get.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.getWriter().println("dopost");
		/*Part pt = req.getPart("img");//一个part代表一个附件
		System.out.println(pt.getSubmittedFileName());
		String uuid=UUID.randomUUID().toString();
		pt.write(uuid+".jpg");//保存附件
		resp.getWriter().println("save successful!");*/
		
		
//		String account=req.getParameter("account");
//		String nickName=req.getParameter("nickName");
//		String password=req.getParameter("password");
//		String age=req.getParameter("age");
//		String sex=req.getParameter("sex");
		Part pt = req.getPart("file");
		String fileName=pt.getSubmittedFileName();
		String prefix=fileName.substring(fileName.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		pt.write(uuid+prefix);//保存附件
		System.out.println(uuid+prefix);
//		
//		UserDao userDao = new UserDao(); 
//		User user=new User();
//		user.setAccount(account);
//		user.setAge(Integer.parseInt(age));
//		user.setNickName(nickName);
//		user.setPassword(password);
//		user.setSex(sex);
//		user.setHeadImage(headImage);
//		userDao.add(user);
//
//		resp.getWriter().println("注册成功！");
	}

}
