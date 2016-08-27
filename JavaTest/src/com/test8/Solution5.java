package com.test8;

import javax.swing.text.Position.Bias;

/**
 * 程序员面试金典 2016-08-24
 * 
 * @author Administrator
 * 
 */
public class Solution5 {

	/**
	 * 确定一个字符串的所有字符是否全都不同
	 * 
	 * @param iniString
	 * @return
	 */
	public boolean checkDifferent(String iniString) {
		// write code here
		for (int i = 0; i < iniString.length(); i++) {
			for (int j = 0; j < iniString.length(); j++) {
				if (i != j && iniString.charAt(i) == iniString.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串
	 * 
	 * @param iniString
	 * @return
	 */
	public String reverseString(String iniString) {
		// write code here
		char[] array = iniString.toCharArray();
		for (int i = 0; i < iniString.length() / 2; i++) {
			char temp = array[i];
			array[i] = array[iniString.length() - i - 1];
			array[iniString.length() - i - 1] = temp;
		}
		return new String(array);
	}

	/**
	 * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
	public boolean checkSam(String stringA, String stringB) {
		// write code here
		if (stringA.length() != stringB.length()) {
			return false;
		} else {
			int[] flag = new int[stringA.length()];
			for (int i = 0; i < stringA.length(); i++) {
				for (int j = 0; j < stringB.length(); j++) {
					if (flag[j] == 0 && stringA.charAt(i) == stringB.charAt(j)) {
						flag[j] = 1;
						break;
					}
				}
			}
			for (int i = 0; i < stringA.length(); i++) {
				if (flag[i] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 将字符串中的空格全部替换为:%20 给定一个string iniString 为原始的串，以及串的长度 int len
	 * 
	 * @param iniString
	 * @param length
	 * @return
	 */
	public String replaceSpace(String iniString, int length) {
		// write code here
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (iniString.charAt(i) == ' ') {
				builder.append("%20");
			} else {
				builder.append(iniString.charAt(i));
			}
		}
		return builder.toString();
	}

	/**
	 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串"aabcccccaaa"经压缩会变成"a2b1c5a3"。
	 * 若压缩后的字符串没有变短，则返回原先的字符串。
	 * 
	 * @param iniString
	 * @return
	 */
	public String zipString(String iniString) {
		// write code here
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < iniString.length(); i++) {
			builder.append(iniString.charAt(i));
			int count = 1;
			for (int j = i + 1; j < iniString.length(); j++) {
				if (iniString.charAt(i) == iniString.charAt(j)) {
					count++;
					i++;
				} else {
					break;
				}
			}
			builder.append(count + "");
		}
		return builder.toString().length() < iniString.length() ? builder
				.toString() : iniString;
	}

	/**
	 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，
	 * 将图像顺时针旋转90度。
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
	public static int[][] transformImage(int[][] mat, int n) {
		// write code here
		for (int i = 0; i < n / 2; i++) {
			// 第i行与第n-i列交换
			// 保存第i行的值
			int[] array = new int[n - 2 * i];
			for (int j = i; j < n - i; j++) {
				array[j - i] = mat[i][j];
			}
			// 顺时针旋转操作
			for (int j = n - i - 1; j >= i; j--) {
				mat[i][j] = mat[n - 1 - j][i];
			}

			for (int j = i; j <= n - i - 1; j++) {
				mat[j][i] = mat[n - i - 1][j];
			}

			for (int j = n - i - 1; j >= i; j--) {
				mat[n - i - 1][n - 1 - j] = mat[j][n - i - 1];
			}
			for (int j = i; j <= n - i - 1; j++) {
				mat[j][n - i - 1] = array[j - i];
			}
		}
		return mat;
	}

	/**
	 * 若N阶方阵中某个元素为0，则将其所在的行与列清零。
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
	public static int[][] clearZero(int[][] mat, int n) {
		// write code here
		// 查找矩阵中存在0的行和列
		int[][] indexes = new int[n * n][2];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					indexes[count][0] = i;
					indexes[count][1] = j;
					count++;
				}
			}
		}
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < n; j++) {
				mat[indexes[i][0]][j] = 0;
				mat[j][indexes[i][1]] = 0;
			}
		}
		return mat;
	}

	/**
	 * 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkReverseEqual(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		// write code here
		for (int i = 0; i < s1.length(); i++) {
			// 若从第i个字符旋转
			String tempS = s1.substring(i + 1) + s1.substring(0, i + 1);
			if (s2.equals(tempS))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		// { 13, 14, 15, 16 } };
		// transformImage(array, 4);

		int[][] array = { { 1, 2, 3 }, { 0, 1, 2 }, { 0, 0, 1 } };
		clearZero(array, 3);
	}

}
