package com.zx.dao.impl;

import com.zx.dao.BaseDao;
import com.zx.dao.IStudentDao;
import com.zx.pojo.Student;

public class StudentDao extends BaseDao implements IStudentDao{

	@Override
	public Student selectStudent(String studentNumber) throws Exception {
		String sql = "select id from student where studentNumber = ?";
		return super.selectOne(sql, Student.class, studentNumber);
	}

	@Override
	public Student insert(Student stu) {
		String sql = "insert into student value(0,?,?,?,?,?,?)";
		System.out.println(stu);
		
		int id = super.insert(sql, stu.getStudentNumber(),stu.getName(),stu.getAge(),stu.getSex(),stu.getPhone(),stu.getCity(),stu.getInfo());
		
		if(id==0) {
			System.out.println("Add Student Failed");
			return null;
		}
		stu.setId(id);
		return stu;
	}

}
