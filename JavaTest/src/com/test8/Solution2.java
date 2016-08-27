package com.test8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2016-08-21 编程练习
 * @author Administrator
 *
 */
public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// NumberOf1(-1234567);
		// NumberOf1(-1);
		IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 });
	}

	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf1(int n) {
		// 将n表示为二进制
		int absN = Math.abs(n);
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while (absN != 0) {
			if (absN % 2 == 1)
				count++;
			list.add(absN % 2);
			absN = absN / 2;
		}
		if (list.size() < 32) {
			for (int i = list.size(); i < 32; i++) {
				list.add(0);
			}
		}
		if (n < 0) {
			count = 0;
			// 负数最高位为0
			list.set(list.size() - 1, 1);
			// 取反
			for (int i = 0; i < list.size() - 1; i++) {
				list.set(i, list.get(i) ^ 1);
			}
			int increment = 1;
			// 加1
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) + increment == 2) {
					list.set(i, 0);
					increment = 1;
				} else {
					list.set(i, list.get(i) + increment);
					increment = 0;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == 1) {
					count++;
				}
			}
			return count + 1;
		} else {
			return count;
		}
	}

	/*
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cols = matrix[0].length;
		int rows = matrix.length;
		int count = cols > rows ? rows : cols;
		count = count % 2 == 0 ? count / 2 : count / 2 + 1;
		if (cols == 1) {
			for (int i = 0; i < rows; i++) {
				list.add(matrix[i][0]);
			}
		} else if (rows == 1) {
			for (int i = 0; i < cols; i++) {
				list.add(matrix[0][i]);
			}
		} else {
			int count1 = 0;
			for (int i = 0; i < count; i++) {
				for (int j = i; j < cols - i; j++) {
					list.add(matrix[i][j]);
					count1++;
				}
				if (count1 == cols * rows) {
					break;
				}
				for (int j = i + 1; j < rows - i; j++) {
					list.add(matrix[j][cols - i - 1]);
					count1++;
				}
				if (count1 == cols * rows) {
					break;
				}
				for (int j = cols - i - 2; j >= i; j--) {
					list.add(matrix[rows - i - 1][j]);
					count1++;
				}
				if (count1 == cols * rows) {
					break;
				}
				for (int j = rows - i - 2; j >= i + 1; j--) {
					list.add(matrix[j][i]);
					count1++;
				}
				if (count1 == cols * rows) {
					break;
				}
			}
		}
		return list;
	}

	/**
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
	 * 
	 * @author Administrator
	 * 
	 */
	public class MyStack {
		private Stack<Integer> stack = new Stack<Integer>();

		public void push(int node) {
			stack.add(node);
		}

		public void pop() {
			stack.pop();
		}

		public int top() {
			return stack.firstElement();

		}

		public int min() {
			int min = stack.get(0);
			for (Integer integer : stack) {
				if (integer < min) {
					min = integer;
				}
			}
			return min;
		}
	}

	/**
	 * 判断根据入栈顺序，判断出栈顺序是否合理
	 * 
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		int len = pushA.length;
		boolean flag = true;
		if (pushA.length == popA.length) {
			List<Integer> poped = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				poped.add(popA[i]);
			}
			for (int i = 0; i < len; i++) {
				if (!poped.contains(pushA[i])) {
					return false;
				}
			}
			poped.clear();
			for (int i = 0; i < len; i++) {
				poped.add(popA[i]);
				// 入栈顺序
				List<Integer> list1 = new ArrayList<Integer>();
				for (int j = len - 1; j >= 0; j--) {
					if (popA[i] == pushA[j]) {
						for (int k = j - 1; k >= 0; k--) {
							if (!poped.contains(pushA[k])) {
								list1.add(pushA[k]);
							}
						}
						break;
					}
				}
				// 出栈顺序
				List<Integer> list2 = new ArrayList<Integer>();
				for (int k = i + 1; k < len; k++) {
					if (list1.contains(popA[k])) {
						list2.add(popA[k]);
					}
				}
				// 判断两个顺序是否一样
				if (list1.size() == list2.size()) {
					for (int j = 0; j < list1.size(); j++) {
						if (list1.get(j) != list2.get(j)) {
							return false;
						}
					}
				} else {
					return false;
				}
			}
			return flag;

		} else {
			return false;
		}
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			list.add(root.val);
			ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
			parent.add(root);
			while (parent.size() != 0) {
				parent = getSameLayer(parent);
				for (TreeNode treeNode : parent) {
					list.add(treeNode.val);
				}
			}
		}
		return list;
	}

	/**
	 * 获取同一层的节点
	 */
	public static ArrayList<TreeNode> getSameLayer(ArrayList<TreeNode> parent) {
		ArrayList<TreeNode> subs = new ArrayList<TreeNode>();
		for (TreeNode treeNode : parent) {
			if (treeNode.left != null)
				subs.add(treeNode.left);
			if (treeNode.right != null)
				subs.add(treeNode.right);
		}
		return subs;
	}

}
