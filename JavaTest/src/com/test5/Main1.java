package com.test5;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			String preStr = scanner.next();
			boolean flag = true;
			for (int i = 1; i < n; i++) {
				String nextStr = scanner.next();
				if (preStr.charAt(preStr.length() - 1) != nextStr.charAt(0)) {
					flag = false;
					continue;
				}
			}
			buffer.append(flag == true ? "Yes\n" : "No\n");
		}
		System.out.println(buffer.toString());
	}
}
