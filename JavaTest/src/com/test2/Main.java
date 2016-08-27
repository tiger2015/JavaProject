package com.test2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String result = "";
		while (scanner.hasNext()) {
			int count = scanner.nextInt();
			if (count < 2)
				break;
			String input = "";
			for (int i = 0; i < count; i++) {
				input += scanner.next() + " ";
			}
			input = input.trim();
			String[] group = input.split(" ");
			int i = 1;
			for (; i < count; i++) {
				if (group[i - 1].charAt(group[i - 1].length() - 1) != group[i]
						.charAt(0)) {

					result += "No\n";
					break;
				}
			}
			if (i == count)
				result += "Yes\n";
		}
		System.out.println(result.substring(0, result.length() - 1));
	}

}
