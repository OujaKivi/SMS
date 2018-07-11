package com.ouja.service;

import com.ouja.beans.Student;

public interface IStudentService {
	//对用户进行验证
	Student checkUser(String num, String password);
	//向DB中添加Student类
	void saveStudent(Student student);
	
}
