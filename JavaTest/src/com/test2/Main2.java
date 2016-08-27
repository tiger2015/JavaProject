package com.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String result = "";
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if (n < 2 || m < 1) {
				break;
			}
			
			List<Integer> list = new ArrayList<>();
			int count = 0;
			for (int i = 0; i < m; i++) {
				int data = scanner.nextInt();
				if (list.size() == 0) {
					list.add(data);
					count++;
				} else if (list.contains(data)) {
					continue;
				} else {
					count++;
					int index = list.size() - 1;
					if (index + 1 == n) {
						list.remove(0);
					}
					list.add(data);
				}
			}
			result += count + "\n";
		}

		System.out.println(result.substring(0, result.length() - 1));

	}

}
