package com.test2;

//抽象类可以没有抽象方法
public abstract class Person implements IPersonUtil {
	private String name;
	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
