package com.example.studentmanagementapi.Model;

public class StudentEntity {
	private long id;
	private int rollNumber;
	private int age;
	private String fname;
	private String lname;
	private String classGrade;
	
	//setter
	public void setId(long id) {
		this.id=id;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber=rollNumber;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setFname(String fname) {
		this.fname=fname;
	}
	
	public void setLname(String lname) {
		this.lname=lname;
	}

	public void setClassGrade(String classGrade) {
		this.classGrade=classGrade;
	}
	
	//getter
	public long getId() {
		return this.id;
	}
	public int getRollNumber() {
		return this.rollNumber;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public String getLname() {
		return this.lname;
	}

	public String getClassGrade() {
		return this.classGrade;
	}
	
	
}
