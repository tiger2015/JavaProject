package com.test2;

import java.util.Calendar;
import java.util.Date;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person stu = new Student("hello");

		// System.out.print(stu.getName());// 不能调用getMajor()方法

		System.out.println(((Student) stu).getMajor());

		// Student stu2=new Person();

		String name = "john";
		// 传递的是值
		stu.setName(name);

		name = "null";
		System.out.println(stu.getName());

		Date date = Calendar.getInstance().getTime();

		// 传递的是date的引用
		((Student) stu).setBirthday(date);
		System.out.println(((Student) stu).getBirthday().toString());

		date.setHours(12);
		System.out.println(((Student) stu).getBirthday().toString());

	}

}
