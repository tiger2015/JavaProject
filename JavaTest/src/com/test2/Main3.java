package com.test2;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte b1=2;
		byte b2=3;
		//byte b3=b1+b2;
		String s1="abc"+"def";//1
		String s2=new String(s1);//2
		if(s1.equals(s2))//3
		System.out.println(".equals succeeded");//4
		if(s1==s2)//5
		System.out.println("==succeeded");//6
	}
}
