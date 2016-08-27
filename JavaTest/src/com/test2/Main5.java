package com.test2;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String inputStr = scanner.next();

		}

	}

	public static int getDeleteTimes(String str) {
		// List<Character> list = new ArrayList<Character>();
		int deletes = 0;
		int len = str.length();
		// 统计所包含的不同字符
		/*
		 * for (int i = 0; i < len; i++) { if (!list.contains(str.charAt(i))) {
		 * list.add(str.charAt(i)); } }
		 */
		// 统计字符出现的次数
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		/*
		 * for (int i = 0; i < list.size(); i++) { map.put(list.get(i), 0); }
		 */
		for (int i = 0; i < len; i++) {
			if (map.containsKey(str.charAt(i))) {
				int count = map.get(str.charAt(i)) + 1;
				map.put(str.charAt(i), count);
			} else {
				map.put(str.charAt(i), 0);
			}
		}
		Iterator<Character> keyIterator = map.keySet().iterator();
		// 剔除之后的字符串
		StringBuilder builder = new StringBuilder();
		// 剔除只有一个字符的字符
		for (int i = 0; i < len; i++) {
			if (map.get(str.charAt(i)) >= 2) {
				builder.append(str.charAt(i));
			} else {
				deletes++;
			}
		}
		String afterDelete = builder.toString();
		if (afterDelete.length()>0&&isHuiwen(builder.toString())) {
			int lastIndex = str.lastIndexOf(afterDelete.charAt(afterDelete
					.length() / 2));
			int firstIndex = str.indexOf(afterDelete.charAt(afterDelete
					.length() / 2));
			if (lastIndex > firstIndex) {
				return deletes - 1;
			} else {
				return deletes;
			}
		} else if(afterDelete.length()>0){
			
			
			
			

		}

		return deletes;
	}

	public static boolean isHuiwen(String str) {

		int len = str.length();
		int mid = len / 2;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
