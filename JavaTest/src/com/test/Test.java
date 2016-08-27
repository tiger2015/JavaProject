package com.test;

public class Test {

	public static void reverse(int arr[]) {

		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 23, 76, 89, 17, 29, 38, 100 };
		//reverse(arr);
		// System.out.println(Arrays.toString(arr));
		// System.out.println(arr.toString());
		User user = new User("123", "123");
		user.setArray(arr);
		System.out.println(user.toString());
		// 按照引用传递，实际是user的地址
		arr[0]=-12;
		System.out.println(user.toString());
		
		String name=user.getUsername();
		name="1231";
		
		System.out.println(user.toString());
		test2(user);
		System.out.println(user.toString());
		int array[]=user.getArray();
		array[0]=-1;
		System.out.println(user.toString());
		boolean flag = false;
		if (flag = true)
		{
		    System.out.println("true");
		}
		else
		{
		    System.out.println("false");
		}

	}

	public static void test2(User user) {
		user.setPassword("2313");
		user.getArray()[0]=0;
	}

}
