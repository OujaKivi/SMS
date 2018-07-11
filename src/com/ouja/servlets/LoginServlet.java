package com.ouja.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ouja.beans.Student;
import com.ouja.service.IStudentService;
import com.ouja.service.StudentServiceImpl;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.接受请求参数
		String num=request.getParameter("num");
		String password=request.getParameter("password");
		//获取session
		HttpSession session= request.getSession();
		//num==null防止地址栏跳转访问，"".equals(num.trim())防止用户输入空串
		if(num==null||"".equals(num.trim())) {
			session.setAttribute("message","学号输入有误");
			//重定向，解决恶意刷新
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		if(num==null||"".equals(password.trim())) {
			session.setAttribute("message","密码输入有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}

		//2.创建Service对象
		IStudentService service=new StudentServiceImpl();
		//3.调用Service对象的checkUser()方法对用户进行验证
		Student student=service.checkUser(num, password);

		//4.验证未通过，则跳转到登录页面，让用户再次输入登录信息，页面给出用户一些提示。
		if(student!=null) {
			session.setAttribute("message","用户名或密码输入有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
		//5.验证通过，则跳转到index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}


}
