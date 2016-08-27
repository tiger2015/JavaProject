package com.test7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// 读取颜色总个数
		int n = scanner.nextInt();
		int[] colors = new int[n];
		// 读取输入颜色
		for (int i = 0; i < n; i++) {
			colors[i] = scanner.nextInt();
		}

		if (n <= 2) {
			System.out.print(n);
		} else {
			do {
				List<Integer> list = getDifferenceColor(colors, n);
				colors = new int[list.size()];
				n = list.size();
				for (int i = 0; i < list.size(); i++) {
					colors[i] = list.get(i);
				}
				List<Integer> temp = getDifferenceColor(colors, n);
				if (temp.size() == list.size()) {
					System.out.print(list.size()/2);
					break;
				}
			} while (true);

		}
	}

	public static int[] isComponent(int color, int colors[]) {
		int[] component = new int[2];
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] != color) {
				for (int j = i + 1; j < colors.length; j++) {
					if (colors[j] != color) {
						if ((colors[i] ^ colors[j]) == color) {
							component[0] = colors[i];
							component[1] = colors[j];
							return component;
						}
					}
				}
			}
		}
		return null;
	}

	public static List<Integer> getDifferenceColor(int[] colors, int n) {
		int[][] result = new int[n][3];
		for (int i = 0; i < n; i++) {
			int[] component = isComponent(colors[i], colors);
			if (component == null) {
				result[i][0] = 0;
				result[i][1] = 0;

			} else {
				result[i][0] = component[0];
				result[i][1] = component[1];
			}
			result[i][2] = colors[i];
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			// list中能产生多少种颜色
			List<Integer> tempList = new ArrayList<Integer>();
			int temp[] = new int[list.size()];
			for (int j = 0; j < list.size(); j++) {
				temp[j] = list.get(j);
				tempList.add(temp[j]);
			}
			for (int j = 0; j < list.size(); j++) {
				for (int k = j + 1; k < list.size(); k++) {
					int tempColor = temp[j] ^ temp[k];
					if (!tempList.contains(tempColor)) {
						tempList.add(tempColor);
					}
				}
			}
			if (result[i][0] == 0) {
				if (!list.contains(result[i][2])) {
					list.add(result[i][2]);
				}
			} else {
				if (!list.contains(result[i][0])
						&& !tempList.contains(result[i][0])) {
					list.add(result[i][0]);
				}
				if (!list.contains(result[i][1])
						&& !tempList.contains(result[i][1])) {
					list.add(result[i][1]);
				}
			}
		}
		return list;
	}
}
