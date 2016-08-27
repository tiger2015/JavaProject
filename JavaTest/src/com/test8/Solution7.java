package com.test8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test8.Solution1.TreeNode;

/**
 * 剑指offer 2016-08-26
 * 
 * @author Administrator
 * 
 */
public class Solution7 {

	/**
	 * 输入一个字符串,包括数字字母符号,可以为空
	 * 
	 * @param str
	 * @return
	 */
	public static int StrToInt(String str) {
		Pattern pattern = Pattern.compile("(\\+|-)?[0-9]{1,}");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			long sum = 0;
			for (int i = str.length() - 1; i >= 1; i--) {
				sum += Math.pow(10, str.length() - i - 1)
						* (str.charAt(i) - 48);
			}
			if (str.charAt(0) == '+') {
				return (int) sum;
			} else if (str.charAt(0) == '-') {
				return (int) -sum;
			} else {
				sum += (str.charAt(0) - 48) * Math.pow(10, str.length() - 1);
				return (int) sum;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 找出数组中任意一个重复的数字
	 * 
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return 重复返回true,没有重复返回false;
	 */
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (!map.keySet().contains(numbers[i])) {
				map.put(numbers[i], 1);
			} else {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			}
		}
		Iterator<Integer> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			int next = iterator.next();
			if (map.get(next) > 1) {
				duplication[0] = next;
				return true;
			}
		}
		return false;
	}

	/**
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-
	 * 1]*A[i+1]*...*A[n-1]。不能使用除法。
	 * 
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int data = 1;
			for (int j = 0; j < A.length; j++) {
				if (i != j)
					data *= A[j];
			}
			B[i] = data;
		}
		return B;
	}

	/**
	 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式 待定
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean match(char[] str, char[] pattern) {

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				if (pattern[i] == '.') {
					i++;
					j++;
				} else if (pattern[i] == '*') {
					while (str[i] == pattern[j - 1]) {
						i++;
					}
				} else if (pattern[i] == str[j]) {
					i++;
					j++;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否表示数值
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(char[] str) {
		// 统计E的个数
		int countOfE = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'E' || str[i] == 'e') {
				countOfE++;
			}
			builder.append(str[i]);
		}
		if (countOfE > 1) {
			return false;
		} else if (countOfE == 1) {
			int indexOfE = builder.toString().indexOf("E");
			if (indexOfE == -1) {
				indexOfE = builder.toString().indexOf("e");
			}
			if (builder.toString().substring(0, indexOfE).contains("."))
				return false;
			if (builder.toString().substring(indexOfE + 1).contains("."))
				return false;
			try {
				Double.parseDouble(builder.toString().substring(0, indexOfE));
			} catch (Exception ex) {
				return false;
			}
			try {
				Double.parseDouble(builder.toString().substring(indexOfE + 1));
			} catch (Exception ex) {
				return false;
			}
			return true;
		} else {
			try {
				double data = Double.parseDouble(builder.toString());
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	private Map<Character, Integer> map = new HashMap<Character, Integer>();
	private List<Character> list = new ArrayList<Character>();

	/**
	 * 找出字符流中第一个只出现一次的字符
	 * 
	 * @param ch
	 */
	// Insert one char from stringstream
	public void Insert(char ch) {
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
		if (!list.contains(ch)) {
			list.add(ch);
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		for (Character ch : list) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return '#';
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 一个链表中包含环，请找出该链表的环的入口结点。
	 * 
	 * @param pHead
	 * @return
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode head1 = pHead;
		List<ListNode> list = new ArrayList<ListNode>();
		while (head1 != null) {
			if (!list.contains(head1)) {
				list.add(head1);
			} else {
				return head1;
			}
			head1 = head1.next;
		}
		return head1;
	}

	/**
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留
	 * 
	 * @param pHead
	 * @return
	 */
	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode pre = pHead;
		ListNode next = pHead.next;
		ListNode prepre = null;
		boolean isDeletePre = false;
		while (next != null && next != pre) {
			if (pre.val == next.val) {
				// 删除next结点
				next = next.next;
				pre.next = next;
				isDeletePre = true;
			} else {
				if (isDeletePre) {
					// 删除pre结点
					if (pre == pHead) {
						pHead = pre.next;
						pre = next;
						next = next.next;
					} else {
						prepre.next = next;
						pre = next;
						next = next.next;
					}
				} else {
					prepre = pre;
					pre = next;
					next = next.next;
				}
				isDeletePre = false;
			}
		}
		if (isDeletePre) {
			if (pHead == pre)
				pHead = null;
			else if (pre != null) {
				prepre.next = null;
			}
		}
		return pHead;
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
	 * 
	 * @param pNode
	 * @return
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// 叶子节点
		if (pNode.left == null && pNode.right == null && pNode.next != null) {
			// pNode为左孩子结点
			if (pNode.next.left == pNode) {
				return pNode.next;
			} else {
				if (pNode.next.next != null) {
					// 父结点位于右子树上
					if (pNode.next.next.right == pNode.next) {
						return null;
					}
					return pNode.next.next;
				} else {
					return null;
				}
			}
		} else {
			// 非叶子结点
			if (pNode.next == null) {
				// 若是根结点
				if (pNode.right != null) {
					return GetPre(pNode.right);
				} else {
					return null;
				}
			} else {
				// 非根结点
				// 有左孩子
				if (pNode.left != null) {
					if (pNode.right != null)
						return pNode.right;
					else
						return pNode.next;
				} else {
					return pNode.right;
				}
			}
		}
	}

	/**
	 * 求中序遍历的前一个结点
	 * 
	 * @param pNode
	 *            该结点不能是根节点
	 * @return
	 */
	public static TreeLinkNode GetPre(TreeLinkNode pNode) {

		if (pNode == null) {
			return null;
		}
		// 叶子节点
		if (pNode.left == null && pNode.right == null) {
			// pNode为左孩子结点
			if (pNode.next.left == pNode) {
				return null;
			} else {
				return pNode.next;
			}
		} else {
			// 非叶子结点
			// 且非根结点
			// 有左孩子
			if (pNode.left != null) {
				return pNode.left;
			} else {
				return pNode;
			}
		}
	}

	/**
	 * 判断一颗二叉树是不是对称的
	 * 
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot) {

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// /System.out.println(StrToInt("-2147483648"));
		// char []array={'1','2','3','-','e'};
		// System.out.println(Arrays.toString(array));
		Solution7 solution7 = new Solution7();
		ListNode node1 = solution7.new ListNode(1);
		ListNode node2 = solution7.new ListNode(1);
		ListNode node3 = solution7.new ListNode(1);
		ListNode node4 = solution7.new ListNode(1);
		ListNode node5 = solution7.new ListNode(1);
		ListNode node6 = solution7.new ListNode(1);
		ListNode node7 = solution7.new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		deleteDuplication(node1);

	}

}
