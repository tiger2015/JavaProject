package com.test9;

import java.util.Scanner;

/**
 * 2016-08-23
 * 
 * @author Administrator
 * 
 */
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		do {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int array[] = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			builder.append(minSub(array) + "\n");
		} while (true);
		String str = builder.toString();
		System.out.print(str.substring(0, str.length()-2));
	}

	public static String minSub(int[] array) {
		int len = array.length * (array.length - 1) / 2;
		int[] sub = new int[len];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				sub[index] = array[i] - array[j];
			}
		}
		// 求最小值与最大值
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < index; i++) {
			if (min > sub[i]) {
				min = sub[i];
			}
			if (max < sub[i]) {
				max = sub[i];
			}
		}

		int minCount = 0;
		int maxCount = 0;
		for (int i = 0; i < index; i++) {
			if (sub[i] == max) {
				maxCount++;
			}
			if (sub[i] == min) {
				minCount++;
			}
		}
		return minCount + " " + maxCount;
	}

}
