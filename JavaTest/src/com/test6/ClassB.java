package com.test6;

public class ClassB extends ClassA {

	public static void play() {
		System.out.println("ClassB-->play");
	}

	public void stop() {
		System.out.println("ClassB-->stop");
	}

	public void pause() {
		System.out.println("ClassB-->pause");
	}

	// 成员函数，编译时看左边，运行时看右边，其余的看左边
	public static void main(String[] args) {
		ClassA a = new ClassB();
		a.play();// 调用ClassA的方法
		a.stop();// 调用ClassB的方法
		a.print();// 调用ClassA的方法

		ClassB b = (ClassB) a;
		b.play();// 调用ClassB的方法
		b.stop();// 调用ClassB的方法
		b.print();// 调用ClassA的方法
		b.pause();// 调用ClassB的方法
		// byte[] buf = new byte[1024*1024*200];
		System.out.println(Thread.currentThread().getName());
	}

	// 若内部类中有静态成员，则该类必须为静态类
	public static class InnerClass {

		private static int sIn = 0;

	}
}
