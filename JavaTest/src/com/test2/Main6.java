package com.test2;

public class Main6 {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
		int[] in = { 3, 2, 4, 1, 6, 5, 7 };
		TreeNode node = new Solutions().reConstructBinaryTree(pre, in);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solutions {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || pre.length == 0)
			return null;

		if (in == null || in.length == 0)
			return null;

		TreeNode root = new TreeNode(pre[0]);

		int index = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				index = i;
				break;
			}
		}
		int[] in1 = new int[index];
		for (int i = 0; i < index; i++) {
			in1[i] = in[i];
		}
		int[] in2 = new int[in.length - index - 1];
		for (int i = index + 1; i < in.length; i++) {
			in2[i - index - 1] = in[i];
		}
        
		
		int[] pre1 = new int[in1.length];
		for (int i = 1; i < pre1.length+1; i++)
			pre1[i - 1] = pre[i];
		int[] pre2 = new int[pre.length - pre1.length];
		for (int i = in1.length+1; i < pre.length; i++) {
			pre2[i - in1.length-1] = pre[i];
		}
		root.left = reConstructBinaryTree(pre1, in1);
		root.right = reConstructBinaryTree(pre2, in2);

		return root;
	}
}