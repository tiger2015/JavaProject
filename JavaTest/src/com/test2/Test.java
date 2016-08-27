package com.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// System.out.println("请输入一个字符串(以回车结束)：");
		// String inputStr = scanner.nextLine();
		long data = scanner.nextLong();
		/*
		 * System.out.println("请输入一个字符(以回车结束)："); char ch =
		 * scanner.next().charAt(0); int count = 0; for (int i = 0; i <
		 * inputStr.length(); i++) { if (inputStr.charAt(i) == ch) { count++; }
		 * } System.out.println(count);
		 */
		/*
		 * inputStr = inputStr.trim(); int index = inputStr.lastIndexOf(' '); if
		 * (index > 0) { System.out.println(inputStr.substring(index).length());
		 * }
		 */

		System.out.println(getResult(data));
	}

	public static String getResult(long ulDataInput) {
		long[] result = new long[(int) Math.sqrt(ulDataInput)];
		int count = 0;
		while (true) {
			if (isSushu(ulDataInput)) {
				result[count] = ulDataInput;
				count++;
				break;
			}
			for (int i = 2; i < Math.sqrt(ulDataInput); i++) {
				if (ulDataInput % i == 0 && isSushu(i)) {
					result[count] = i;
					ulDataInput = ulDataInput / i;
					count++;
					break;
				}
			}
		}
		Arrays.sort(result, 0, count);
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp += result[i] + " ";
		}

		return temp.trim();
	}

	public static boolean isSushu(long data) {
		if (data == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(data); i++) {
			if (data % i == 0)
				return false;
		}
		return true;
	}
}
