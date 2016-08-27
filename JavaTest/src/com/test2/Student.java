package com.test2;

import java.util.Date;

public class Student extends Person {
	private String major;
	private Date birthday;

	public Student(String major) {
		this.major = major;
	}

	public Student() {

	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public Object clone1() {
		// TODO Auto-generated method stub
		return null;
	}

}
