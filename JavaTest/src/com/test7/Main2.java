package com.test7;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		// int array[] = new int[n];
		// for (int i = 0; i < n; i++) {
		// array[i] = scanner.nextInt();
		// }

		MyElement root = component(3, 2);

		for (int i = 0; i < root.next.length; i++) {
			System.out.println(root.next[i].index);
		}

	}

	public static MyElement component(int n, int k) {
		if (k == 0) {
			MyElement root = new MyElement(0, n);
			return root;
		} else {
			MyElement parent = component(n, k - 1);
			int size = parent.next.length;
			for (int i = 0; i < size; i++) {
				parent.next[i] = new MyElement(k, n);
				
			}
			return parent;
		}
	}
}

class MyElement {
	public int index;
	public MyElement next[];

	public MyElement(int index, int size) {
		this.index = index;
		if (index == 0) {
			next = new MyElement[size];
		} else {
			next = new MyElement[size - index + 1];
		}
	}
}
