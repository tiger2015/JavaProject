package com.test7;

public class Main3 {
	private static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib(8);
		System.out.println(cnt);

	}

	public static int fib(int n) {
		cnt++;
		if (n == 0)
			return 1;
		else if (n == 1)
			return 2;
		else
			return fib(n - 1) + fib(n - 2);
	}
}
