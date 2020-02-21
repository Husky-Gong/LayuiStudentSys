package com.zx.service.impl;

import com.zx.dao.IStudentDao;
import com.zx.dao.impl.StudentDao;
import com.zx.pojo.Student;
import com.zx.service.IStudentService;

public class StudentServiceImpl implements IStudentService{

	@Override
	public Student getStudent(String studentNumber, String name, int age, String sex, String phone, String city,
			String info) {
		Student stu = new Student();
		stu.setStudentNumber(studentNumber);
		stu.setName(name);
		stu.setAge(age);
		stu.setSex(sex);
		stu.setPhone(phone);
		stu.setCity(city);
		stu.setInfo(info);
		return stu;
	}

	@Override
	public boolean addStudent(Student stu) throws Exception {
		IStudentDao studentDao = new StudentDao();
		System.out.println(stu.getStudentNumber());
		Student student = studentDao.selectStudent(stu.getStudentNumber());
		
		if(student != null) {
			System.out.println("Has existed!");
			return false;
		}
		stu = studentDao.insert(stu);
		return stu == null?false:true;
	}

	
	
	
}
