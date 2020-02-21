package com.zx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zx.pojo.Student;
import com.zx.service.IStudentService;
import com.zx.service.impl.StudentServiceImpl;




@WebServlet
public class StudentController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2149914751987622307L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String service = req.getParameter("service");
		if("add".equals(service)) {
			add(req,resp);
		}else if("update".equals(service)) {
			update(req,resp);
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		IStudentService studentService = new StudentServiceImpl();
		
		String studentNumber = req.getParameter("stNo");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String sex = req.getParameter("sex");
		String phone = req.getParameter("phone");
		String city = req.getParameter("city");
		String info = req.getParameter("info");
		
		Student stu = studentService.getStudent(studentNumber, name, age, sex, phone, city, info);
		boolean flag;
		try {
			flag = studentService.addStudent(stu);
			// if new student added successfully
			if(flag) {
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("json/text;charset=UTF-8");
				JSONObject rs = new JSONObject();
				rs.put("code", 200);
				rs.put("msg", "success");
				resp.getWriter().print(rs.toJSONString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
