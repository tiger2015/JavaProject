package com.test8;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016-08-22 编程练习
 * 
 * @author Administrator
 * 
 */
public class Solution3 {

	/**
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean VerifySquenceOfBST(int[] sequence) {
		int length = sequence.length;
		if (length == 0)
			return false;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		int i = 0;
		for (i = 0; i < length - 1; i++) {
			if (sequence[i] < sequence[length - 1]) {
				left.add(sequence[i]);
			} else {
				break;
			}
		}
		for (; i < length - 1; i++) {
			if (sequence[i] > sequence[length - 1]) {
				right.add(sequence[i]);
			} else {
				break;
			}
		}
		if (left.size() + right.size() == length - 1) {
			// 判断左右子树
			int[] leftArray = new int[left.size()];
			int[] rightArray = new int[right.size()];
			for (i = 0; i < left.size(); i++) {
				leftArray[i] = left.get(i);
			}

			for (i = 0; i < right.size(); i++) {
				rightArray[i] = right.get(i);
			}
			boolean flag1 = true;
			boolean flag2 = true;
			if (leftArray.length > 0) {
				flag1 = VerifySquenceOfBST(leftArray);
			}

			if (rightArray.length > 0) {
				flag2 = VerifySquenceOfBST(rightArray);
			}
			return flag1 && flag2;
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
	 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		findAllPath(lists, root, target, list);
		return lists;
	}

	/**
	 * 
	 * @param lists
	 *            保存所有的路径
	 * @param root
	 *            当前节点
	 * @param target
	 * @param list
	 *            当前路径节点信息
	 */
	public static void findAllPath(ArrayList<ArrayList<Integer>> lists,
			TreeNode root, int target, ArrayList<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		if (root.left == null && root.right == null) {
			// 输出一条路径
			ArrayList<Integer> subList = new ArrayList<Integer>();
			int sum = 0;
			for (TreeNode treeNode : list) {
				sum += treeNode.val;
			}

			if (sum == target) {
				for (TreeNode treeNode : list) {
					subList.add(treeNode.val);
				}
				lists.add(subList);
			}
		} else {
			findAllPath(lists, root.left, target, list);
			findAllPath(lists, root.right, target, list);
		}
		if (list.size() >= 1) {
			list.remove(list.size() - 1);
		}
	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	/**
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head
	 * 
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		
		// 记录random节点指向的节点位置
		ArrayList<Integer> list = new ArrayList<Integer>();
		RandomListNode p = pHead;
		while (p != null) {
			RandomListNode temp = pHead;
			int index = 0;
			while(p.random!=temp)
			{
				temp = temp.next;
				index++;
			}		
			if (p.random == null)
				index = -1;
			list.add(index);
			p=p.next;
		}

		// 完成节点的复制
		RandomListNode newHead = new RandomListNode(pHead.label);
		RandomListNode newP = newHead;
		p = pHead.next;
		while (p != null) {
			RandomListNode node = new RandomListNode(p.label);
			newP.next = node;
			p = p.next;
			newP=newP.next;
		}
		// 求出位置
		newP = newHead;
		int i = 0;
		while (newP != null) {		
			if (list.get(i) < 0) {
				newP.random = null;
			} else {
				int j = 0;
				p = newHead;
				while(j!=list.get(i)&&p.next!=null)
				{
					p = p.next;
					j++;
				}
				newP.random = p;
			}
			newP = newP.next;
			i++;
		}
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
