package com.test;

import java.util.Arrays;

public class User {
	private String username;
	private String password;
	private int[] array;

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int[] getArray() {
		// 返回的是一个拷贝
		return array.clone();
	}

	public void setArray(int[] array) {
		this.array = array.clone();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", array=" + Arrays.toString(array) + "]";
	}
}
