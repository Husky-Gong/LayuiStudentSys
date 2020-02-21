package com.zx.dao;

import com.zx.pojo.Student;

public interface IStudentDao {

	Student selectStudent(String studentNumber) throws Exception;

	Student insert(Student stu);
	
}
