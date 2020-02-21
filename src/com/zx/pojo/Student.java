package com.zx.pojo;

public class Student {
	private int id;
	private String studentNumber;
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String city;
	private String info;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", phone=" + phone + ", city=" + city + ", info=" + info + "]";
	}
	public Student() {
		super();
	}
	
}
