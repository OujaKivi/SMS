package com.ouja.service;

import com.ouja.beans.Student;
import com.ouja.dao.IStudentDao;
import com.ouja.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao dao;
	
	public StudentServiceImpl() {
		dao=new StudentDaoImpl();
	}
	
	@Override
	public Student checkUser(String num, String password) {
		// TODO Auto-generated method stub
		
		return dao.selectStudentLogin(num,password);
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
			dao.insertStudent(student);
			
		
	}
	
}
