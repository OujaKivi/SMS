package com.ouja.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouja.beans.Student;
import com.ouja.service.IStudentService;
import com.ouja.service.StudentServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单参数
		String num=request.getParameter("num");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String ageStr=request.getParameter("age");
		String scoreStr=request.getParameter("score");
		
//		if(num==null||"".equals(num.trim())) {
//			
//		}
		
		Integer age=Integer.valueOf(ageStr.trim());
		Double score = Double.valueOf(scoreStr.trim());
		//2.创建Student随想
		Student student=new Student(num,name,age,score);
		student.setPassword(password);
		
		//3.创建Service对象
		IStudentService service=new StudentServiceImpl();
		
		//4.调用Service对象的saveStudent（）方法将对象写入DB
		service.saveStudent(student);
		//5.写入失败，则跳转到注册页面，重新注册
		
		//6.写入成功，则跳转到登陆页面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

}
