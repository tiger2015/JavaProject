package com.test8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 剑指offer编程练习 2016-08-25
 * 
 * @author Administrator
 * 
 */
public class Solution6 {

	/**
	 * 把只包含因子2、3和5的数称作丑数，求按从小到大的顺序的第N个丑数
	 * 
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {
		if (index == 0)
			return 0;
		int[] data = new int[index];
		int[] temp = { 1, 2, 3, 4, 5, 6 };
		if (index <= temp.length) {
			return temp[index - 1];
		} else {
			for (int i = 0; i < temp.length; i++) {
				data[i] = temp[i];
			}
			int len = temp.length;
			for (int i = 6; i < index; i++) {
				// 求下一个丑数,下一个丑数为前一个丑数乘以2或3或5
				int min2 = Integer.MAX_VALUE;
				int min3 = Integer.MAX_VALUE;
				int min5 = Integer.MAX_VALUE;
				for (int j = 0; j < len; j++) {
					if (data[j] * 2 > data[len - 1]) {
						if (data[j] * 2 < min2) {
							min2 = data[j] * 2;
						}
					}
					if (data[j] * 3 > data[len - 1]) {
						if (data[j] * 3 < min3) {
							min3 = data[j] * 3;
						}
					}
					if (data[j] * 5 > data[len - 1]) {
						if (data[j] * 5 < min5) {
							min5 = data[j] * 5;
						}
					}
				}
				data[i] = (min2 > min5 ? min5 : min2) > min3 ? min3
						: (min2 > min5 ? min5 : min2);
				len++;
			}
			return data[index - 1];
		}
	}

	/**
	 * 判断丑数
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isUglyNumber(int n) {
		if (n == 1 || n == 2)
			return true;

		do {
			if (n % 2 == 0) {
				n = n / 2;
			} else if (n % 3 == 0) {
				n = n / 3;
			} else if (n % 5 == 0) {
				n = n / 5;
			} else {
				break;
			}
		} while (n > 1);
		if (n == 1)
			return true;
		return false;
	}

	/**
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
	 * 
	 * @param array
	 * @return
	 */
	public int InversePairs(int[] array) {
		long p = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					p++;
				}
			}
		}
		return (int) (p % 1000000007);
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 输入两个链表，找出它们的第一个公共结点。
	 * 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		// while (pHead1 != null) {
		// ListNode head2 = pHead2;
		// while (head2 != null) {
		// if (pHead1 == head2) {
		// return head2;
		// }
		// head2 = head2.next;
		// }
		// pHead1 = pHead1.next;
		// }

		ListNode head1 = pHead1;
		ListNode head2 = pHead2;
		while (head1 != null && head2 != null) {
			head1 = head1.next;
			head2 = head2.next;
		}
		int count = 0;
		ListNode head = head1 == null ? head2 : head1;
		while (head != null) {
			head = head.next;
			count++;
		}
		if (head1 == null) {
			while (count > 0) {
				pHead2 = pHead2.next;
				count--;
			}
		} else {
			while (count > 0) {
				pHead1 = pHead1.next;
				count--;
			}
		}
		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead2;
	}

	/**
	 * 统计一个数字在排序数组中出现的次数。
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int GetNumberOfK(int[] array, int k) {
		// 先查找K出现的位置
		int start = 0;
		int end = array.length - 1;
		int index = -1;
		while (start <= end && start >= 0 && end >= 0) {
			int mid = (start + end) / 2;
			if (array[mid] < k) {
				// 升序
				if (array[start] < array[end]) {
					start = mid + 1;

				} else {
					// 降序
					end = mid - 1;
				}
			} else if (array[mid] > k) {
				// 升序
				if (array[start] < array[end]) {
					end = mid - 1;
				} else {
					// 降序
					start = mid - 1;
				}
			} else {
				index = mid;
				break;
			}
		}
		if (index < 0)
			return 0;
		int count = 1;
		System.out.println(index);
		for (int i = index - 1; i >= 0; i--) {
			if (array[i] != array[index]) {
				break;
			}
			count++;
		}
		for (int i = index + 1; i < array.length; i++) {
			if (array[i] != array[index]) {
				break;
			}
			count++;
		}
		return count;
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
	 * 求一棵树的深度
	 * 
	 * @param pRoot
	 * @return
	 */
	public int TreeDepth(TreeNode pRoot) {
		if (pRoot == null) {
			return 0;
		} else {
			int leftH = TreeDepth(pRoot.left) + 1;
			int rightH = TreeDepth(pRoot.right) + 1;
			return leftH > rightH ? leftH : rightH;
		}
	}

	/**
	 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
	 * 
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;
		int leftH = 0;
		int rightH = 0;
		if (root.left != null) {
			leftH = TreeDepth(root.left);
		}
		if (root.right != null) {
			rightH = TreeDepth(root.right);
		}
		if (Math.abs(rightH - rightH) > 1) {
			return false;
		} else {
			return IsBalanced_Solution(root.left)
					&& IsBalanced_Solution(root.right);
		}
	}

	/**
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。 num1,num2分别为长度为1的数组。传出参数
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.keySet().contains(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		Iterator<Integer> iterator = map.keySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			int temp = iterator.next();
			if (map.get(temp) == 1) {
				if (count == 0) {
					num1[0] = temp;
					count++;
				} else if (count == 1) {
					num2[0] = temp;
					count++;
					break;
				}
			}
		}
	}

	/**
	 * 输出所有和为S的连续正数序列
	 * 
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		// 数字不超过sum/2
		if (sum == 1)
			return list;
		for (int i = 1; i <= sum / 2 + 1; i++) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			int s = 0;
			for (int j = i; j <= sum / 2 + 2; j++) {
				s += j;
				if (s < sum) {
					subList.add(j);
				} else if (s == sum) {
					subList.add(j);
					list.add(subList);
					break;
				} else if (s > sum) {
					break;
				}
			}
		}
		return list;
	}

	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < sum) {
				int target = sum - array[i];
				if (target >= array[i]) {
					int start = i + 1;
					int end = array.length - 1;
					int mid = (start + end) / 2;
					int index = -1;
					while (start <= end && start >= 0 && end >= 0) {
						if (array[mid] < target) {
							start = mid + 1;
						} else if (array[mid] > target) {
							end = mid - 1;
						} else {
							if (list.size() == 0) {
								list.add(array[i]);
								list.add(target);
							} else {
								if (list.get(0) * list.get(1) > array[i]
										* target) {
									list.clear();
									list.add(array[i]);
									list.add(target);
								}
							}
							break;
						}
						mid = (start + end) / 2;
					}
				}
			}
		}
		return list;
	}

	/**
	 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString(String str, int n) {
		if (str.length() == 0)
			return "";
		if (n >= str.length()) {
			n = n % str.length();
		}
		return str.substring(n) + str.substring(0, n);

	}

	/**
	 * 翻转单词顺序
	 * 
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
		if (str.trim().length() == 0)
			return str;
		String array[] = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i--) {
			builder.append(array[i] + " ");
		}
		return builder.toString().substring(0, str.length());
	}

	/**
	 * 求扑克牌的顺序是否连续
	 * 
	 * @param numbers
	 * @return
	 */
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5) {
			return false;
		}
		// 统计非大小王的个数
		int numberOfZero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				numberOfZero++;
			}
		}
		// 非王的数字
		int[] array = new int[numbers.length - numberOfZero];
		int numberOfNoneZero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0) {
				array[numberOfNoneZero] = numbers[i];
				numberOfNoneZero++;
			}
		}
		// 排序
		Arrays.sort(array);
		// 判断非王中是否有相同的
		// 如果有相同的返回false
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				return false;
			} else {
				min += array[i + 1] - array[i] - 1;
			}
		}

		if (min > numberOfZero) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 * 
	 * @param n
	 * @return
	 */
	public int Sum_Solution(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return Sum_Solution(n - 1) + n;
		}
	}

	/**
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int Add(int num1, int num2) {

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		// GetNumberOfK(array, 3);
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array, num1, num2);
	}

}
