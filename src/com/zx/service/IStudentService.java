package com.zx.service;

import com.zx.pojo.Student;

public interface IStudentService {
	Student getStudent(String studentNumber, String name, int age, String sex, String phone, String city, String info);
	
	boolean addStudent(Student stu) throws Exception;
}
