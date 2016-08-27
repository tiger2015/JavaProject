package test3;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// 得到数据组数
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int m = scanner.nextInt();// 牌的张数m*2
			int k = scanner.nextInt();// 洗牌的次数
			int[] array = new int[m * 2];
			for (int j = 0; j < m * 2; j++) {
				array[j] = scanner.nextInt();
			}
			// 洗牌
			for (int j = 0; j < k; j++) {
				array = component(array);
			}
			// 打印
			for (int j = 0; j < m * 2; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
		}

	}

	public static int[] component(int[] array) {
		int len = array.length;
		int[] temp = new int[len];
		for (int i = 0; i < len / 2; i++) {
			temp[i] = array[i];
			temp[i + 1] = array[len / 2 + i];
		}
		return temp;
	}
}
