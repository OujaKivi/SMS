package com.ouja.dao;

import com.ouja.beans.Student;

public interface IStudentDao {

	Student selectStudentLogin(String num, String password);

	void insertStudent(Student student);


}
