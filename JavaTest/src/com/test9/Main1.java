package com.test9;

import java.util.Scanner;
/**
 * 2016-08-23
 * @author Administrator
 *
 */
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		StringBuilder builder=new StringBuilder();
		do {
			String str = scanner.nextLine();
			if (str.trim().length() > 0) {
				builder.append(moveUpper(str.toCharArray())+"\n");
			} else {
				break;
			}
		} while (true);
		System.out.print(builder.toString());

	}

	public static String moveUpper(char[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] >= 'A' && array[j] <= 'Z' && array[j + 1] >= 'a'
						&& array[j + 1] <= 'z') {
					char temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
		}
		return builder.toString();
	}
}
