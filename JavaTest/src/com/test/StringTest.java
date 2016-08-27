package com.test;

import java.io.Console;
import java.math.BigInteger;
import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloStr = "hello";
		String helloStr1 = helloStr;
		String helloStr2 = "hello";
		System.out.println(helloStr == helloStr1);// true
		System.out.println(helloStr == "hello");// true
		System.out.println(helloStr2 == helloStr);// true
		System.out.println(helloStr.equals(helloStr1));// true 值做比较
		System.out.println(helloStr.equals("hello"));// true
		System.out.println(helloStr.equals(helloStr2));// true
		helloStr = "hel";
		System.out.println(helloStr1);
		char ch = '曾';// unicode 16位
		System.out.println(ch);
		System.out.println(helloStr.codePointAt(0));// Unicode 代码点
		Scanner in = new Scanner(System.in);
		System.out.println(in.nextLine());
		/*
		 * Console console=System.console();
		 * System.out.println(console.readPassword("password:"));
		 */
	}

}
