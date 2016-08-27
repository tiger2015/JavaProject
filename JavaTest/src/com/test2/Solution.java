package com.test2;

import java.util.ArrayList;

public class Solution {
	public static boolean Find(int[][] array, int target) {
		int cols = array[0].length;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}

	public static String replaceSpace(StringBuffer str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				builder.append("%20");
			} else {
				builder.append(str.charAt(i));
			}
		}
		return builder.toString();

	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };

		System.out.println(Find(array, 7));

		StringBuffer buffer = new StringBuffer("hello world");
		System.out.println(replaceSpace(buffer));

		ArrayList<Integer> list = new ArrayList<>();

		list.add(0, 1);
		list.add(0, 2);
		list.add(0, 3);
		System.out.println(list.toString());
		int[] it = new int[0];
		System.out.println(it.length);
	}

	public int minNumberInRotateArray(int[] array) {

		return 0;
	}
}
