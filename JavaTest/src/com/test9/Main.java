package com.test9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 2016-08-23
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.nextLine().trim().length() > 0) {

		}

	}

	public static int delete(String str) {
		// 统计单个字符
		List<Character> single = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count == 1 && !single.contains(str.charAt(i))) {
				single.add(str.charAt(i));
			}
		}
		// 至少要删除不同字符中的n-1个字符
		// 删除n-1个字符
		for (Character character : single) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (!single.contains(str.charAt(i))) {
					builder.append(str.charAt(i));
				} else if (str.charAt(i) == character) {
					builder.append(str.charAt(i));
				}
			}
			if (isLooper(builder.toString())) {
				return single.size() - 1;
			}
		}
		// 如果删除n-1个字符还不是回文
		// 删除n个字符
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (!single.contains(str.charAt(i))) {
				builder.append(str.charAt(i));
			}
		}
		if (isLooper(builder.toString())) {
			return single.size();
		}
		// 若删除了单个字符后还不是回文
		str=builder.toString();
		int amount=single.size();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count%2==1) {
				amount++;
			}
		}

		return 0;
	}

	/***
	 * 判断是否是回文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLooper(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
