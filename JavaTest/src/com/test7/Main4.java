package com.test7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 行
		int m = scanner.nextInt();// 列
		List<Point> points = new ArrayList<Point>();
		insert(n, m, 0, 0, points);
		System.out.println(points.size());

	}

	public static void insert(int n, int m, int x, int y, List<Point> points) {
		boolean flag = false;
		for (int j = 0; j < m; j++) {
			Point point = new Point();
			point.x = j;
			point.y = y;
			for (int i = 0; i < points.size(); i++) {
				if (getDistance(point, points.get(i)) == 2) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				points.add(point);
			}
		}
		if (y == m) {
			return;
		} else {
			insert(n, m, 0, y + 1, points);
		}
	}

	public static int getDistance(Point point1, Point point2) {

		return (int) Math.sqrt(Math.pow((point1.x - point2.x), 2)
				+ Math.pow((point1.y - point2.y), 2));
	}
}

class Point {
	public int x;
	public int y;

}
