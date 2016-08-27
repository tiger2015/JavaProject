package com.test2;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String result = "";
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if (n == 0 || m == 0)
				break;
			int[] scores = new int[n];
			for (int i = 0; i < n; i++) {
				scores[i] = scanner.nextInt();
			}

			for (int i = 0; i < m; i++) {
				String str = scanner.next().trim();
				int start = Integer.parseInt(scanner.next().trim());
				int end = Integer.parseInt(scanner.next().trim());
				if (str.charAt(0) == 'Q') {
					int max = scores[start - 1];
					if(start>end)
					{
						for (int j =end - 1; j < start; j++) {
							if (scores[j] > max) {
								max = scores[j];
							}
						}
					}else{
						for (int j = start - 1; j < end; j++) {
							if (scores[j] > max) {
								max = scores[j];
							}
						}
					}
					
					result += max + "\n";
				} else {
					scores[start - 1] = end;
				}
			}
		}

		System.out.println(result.substring(0, result.lastIndexOf("\n")));
	}

}
