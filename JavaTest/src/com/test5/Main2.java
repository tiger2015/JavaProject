package com.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		while (input.hasNextInt()) {
			int n = input.nextInt();// cache大小
			int m = input.nextInt();// 页面请求数
			int count = 0;
			List<Integer> cache = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				int page = input.nextInt();
				if (cache.size() < n) {
					if (cache.contains(new Integer(page))) {
						continue;
					} else {
						cache.add(page);
						count++;
					}
				} else if (cache.size() == n) {
					if (cache.contains(new Integer(page))) {
						continue;
					} else {
						cache.remove(0);
						cache.add(page);
						count++;
					}
				}
			}
			buffer.append(count + "\n");
		}
		System.out.print(buffer.toString());
	}

}
