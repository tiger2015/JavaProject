package com.test8;

import java.util.ArrayList;
import java.util.List;
/**
 * 编程练习 2016-08-20
 * @author Administrator
 *
 */
public class Solution1 {
	public static boolean Find(int[][] array, int target) {
		int cols = array[0].length;
		int rows = array.length;
		boolean flag = false;
		for (int i = 0; i < cols; i++) {
			int middle = (rows - 1) / 2;
			do {
				if (array[middle][i] > target) {
					if (middle == 0)
						break;
					middle = (middle - 1) / 2;
				} else if (array[middle][i] < target) {
					if (middle == rows - 1)
						break;
					middle = (middle + rows) / 2;
				} else {
					flag = true;
					break;
				}
			} while (true);
			if (flag == true) {
				break;
			}
		}
		return flag;
	}

	public String replaceSpace(StringBuffer str) {
		int len = str.length();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == ' ') {
				builder.append("%20");

			} else {
				builder.append(str.charAt(i));
			}
		}

		return builder.toString();
	}

	// 链表节点
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (listNode != null) {
			list.add(0, listNode.val);
			listNode = listNode.next;
		}

		return list;
	}

	// 二叉树节点
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		// pre的第一个点为根节点
		TreeNode node = new TreeNode(pre[0]);
		int leftCount = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] != pre[0]) {
				leftCount++;
			} else {
				break;
			}
		}
		int[] leftPre = new int[leftCount];
		int[] leftIn = new int[leftCount];
		int[] rightPre = new int[pre.length - leftCount - 1];
		int[] rightIn = new int[pre.length - leftCount - 1];

		for (int i = 0; i < in.length; i++) {
			if (i <= leftCount - 1) {
				leftIn[i] = in[i];
			} else if (i > leftCount) {
				rightIn[i - leftCount - 1] = in[i];
			}
		}

		for (int i = 1; i < pre.length; i++) {
			if (i <= leftCount) {
				leftPre[i - 1] = pre[i];
			} else if (i > leftCount) {
				rightPre[i - leftCount - 1] = pre[i];
			}
		}
		// 构建左子树
		if (leftPre.length > 0) {
			node.left = reConstructBinaryTree(leftPre, leftIn);
		}
		// 构建右子树
		if (rightPre.length > 0) {
			node.right = reConstructBinaryTree(rightPre, rightIn);
		}
		return node;
	}

	// 数组旋转
	public int minNumberInRotateArray(int[] array) {
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] <= array[i]) {
				continue;
			} else {
				index = i;
				break;
			}
		}

		return array[index];
	}

	/*
	 * 大家都知道斐波那契数列，现在要求输入一个整数n， 请你输出斐波那契数列的第n项。n<=39
	 */
	public static int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			// 若采用递归，则在时间上比循环慢
			int pre1 = 0;
			int pre2 = 1;
			for (int i = 1; i < n; i++) {
				int temp = pre2;
				pre2 = pre1 + pre2;
				pre1 = temp;
			}
			return pre2;

		}
	}

	/*
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 */
	public static int JumpFloor(int target) {
		int count = 0;
		for (int i = 0; i <= target; i++) {
			for (int j = 0; j <= target; j++) {
				if (i + j * 2 == target) {
					System.out.println("i=" + i + ",j=" + j);
					if (i == 0 || j == 0) {
						count++;
					} else {
						count += getComponents(i + j, i < j ? i : j);
					}
				}
			}
		}
		return count;
	}

	// 计算阶乘会出现溢出
	public static long getNMul(int n) {
		if (n == 0) {
			return 1;
		} else {
			long sum = 1;
			for (int i = 1; i <= n; i++) {
				sum *= i;
			}
			return sum;
		}

	}

	// 求排列数
	public static long getComponents(int n, int k) {
		long sum = 0;
		long s1 = 1;
		for (int i = n; i >= n - k + 1; i--) {
			s1 *= i;
		}
		long s2 = getNMul(k);
		return s1 / s2;
	}

	/*
	 * 给定一个double类型的浮点数base和int类型的整数exponent。 求base的exponent次方。
	 */
	public double Power(double base, int exponent) {
		double sum = 1;
		// 若exponent大于等于0
		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				sum *= base;
			}
		} else if (exponent == 0) {
			return 1;
		} else {
			for (int i = 0; i < -exponent; i++) {
				sum *= base;
			}
			sum = 1.0 / sum;
		}
		return sum;
	}

	/*
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有的奇数位于数组的前半部分， 所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 */
	public void reOrderArray(int[] array) {
		List<Integer> list0 = new ArrayList<Integer>();// 偶数
		List<Integer> list1 = new ArrayList<Integer>();// 奇数
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				list0.add(array[i]);
			} else {
				list1.add(array[i]);
			}
		}
		int i = 0;
		for (Integer integer : list1) {
			array[i] = integer;
			i++;
		}
		for (Integer integer : list0) {
			array[i] = integer;
			i++;
		}
	}

	/**
	 * 输入一个链表，输出该链表中倒数第k个结点。
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		int len = 1;
		ListNode temp = head;
		if (head == null) {
			return null;
		}
		while (head.next != null) {
			len++;
			head = head.next;
		}

		if (k > len) {
			return null;
		} else {
			for (int i = 1; i < len - k + 1; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	/**
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 * 
	 * @param head
	 * @return
	 */
	public ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		} else {
			ListNode pre = head;
			ListNode next = head.next;
			while (next != null) {
				pre.next = next.next;
				next.next = head;
				head = next;
				next = pre.next;
			}
			return head;
		}
	}

	/**
	 * 输入两个单调递增的链表，输出两个链表合成后的链表， 当然我们需要合成后的链表满足单调不减规则。
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else {
			ListNode head = new ListNode(0);
			ListNode next = head;
			ListNode next1 = list1;
			ListNode next2 = list2;
			while (next1 != null && next2 != null) {
				if (next1.val >= next2.val) {
					next.next = new ListNode(next2.val);
					next2 = next2.next;
				} else {
					next.next = new ListNode(next1.val);
					next1 = next1.next;
				}
				next = next.next;
			}

			if (next1 == null) {
				while (next2 != null) {
					next.next = new ListNode(next2.val);
					next = next.next;
					next2 = next2.next;
				}
			}

			if (next2 == null) {
				while (next1 != null) {
					next.next = new ListNode(next1.val);
					next = next.next;
					next1 = next1.next;
				}

			}
			return head.next;
		}

	}

	/**
	 * 输入两棵二叉树A，B，判断B是不是A的子结构
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val)
				result = compareTree(root1, root2);
			if (result != true)
				result = compareTree(root1.left, root2);
			if (result != true)
				result = compareTree(root1.right, root2);
		}

		return result;
	}

	public static boolean compareTree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return compareTree(root1.left, root2.left)
				& compareTree(root1.right, root2.right);
	}

	/**
	 * 左右交换 二叉树的镜像
	 * 
	 * @param root
	 */
	public void Mirror(TreeNode root) {
		if (root != null) {
			if (root.left != null && root.right != null) {
				TreeNode left = root.left;
				root.left = root.right;
				root.right = left;
				Mirror(root.left);
				Mirror(root.right);
			} else if (root.left != null && root.right == null) {
				root.right = root.left;
				root.left = null;
				Mirror(root.right);
			} else if (root.left == null && root.right != null) {
				root.left = root.right;
				root.right = null;
				Mirror(root.left);
			}
		}
	}

	/*
	 * 先根遍历
	 */
	public void preScan(List<Integer> list, TreeNode root1) {
		list.add(root1.val);
		preScan(list, root1.left);
		preScan(list, root1.right);
	}

	// 中根遍历
	public void midScan(List<Integer> list, TreeNode root1) {
		preScan(list, root1.left);
		list.add(root1.val);
		preScan(list, root1.right);
	}

	// 后根遍历
	public void lastScan(List<Integer> list, TreeNode root1) {
		preScan(list, root1.left);
		preScan(list, root1.right);
		list.add(root1.val);
	}

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
	 * 
	 * @param matrix
	 * @return
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cols = matrix[0].length;
		int rows = matrix.length;
	    int k=0;
	    int m=0;
		for(int i=0;i<cols+rows;i=i+4)
		{
			//上
			for(int k1=k;k1<cols-k;k1++)
			{
				list.add(matrix[k][k1]);
			}
			//左
			for(int k2=k+1;k2<rows-m;k2++)
			{
				list.add(matrix[cols-k][k2]);
			}
			//下
			
			 
			
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };

		Find(array, 7);
		System.out.println(Fibonacci(40));
		System.out.println(JumpFloor(29));
		System.out.println(getNMul(27));
	}
}