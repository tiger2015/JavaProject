package com;

public class StringTest {

	private static final int cA;
	static {
		cA = 1;
	}

	public StringTest() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = new String(str1);

		System.out.println("str1 hashcode:" + str1.hashCode());
		System.out.println("str2 hashcode:" + str2.hashCode());
		System.out.println("str3 hashcode:" + str3.hashCode());

		System.out.println(str1 == str2);// false 比较内容及地址
		System.out.println(str1.equals(str2));// true 比较字符串内容

		System.out.println("abc" == str3);// false
		System.out.println(str1.equals(str3));// true

		final String fStr = "1231";
		System.out.println(fStr);

		float f1 = 0.23F;
		short s1 = -32768; // 当超过范围时，要强制转换，如果在-32768到32767之间不用强制转换
		byte b1 = -128;// byte为-128到127
		
		short s2=(short) (s1-b1);

	}

}
