package com.test8;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

	/**
	 * 输入n个整数，找出其中最小的K个数 2016-08-23
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input.length >= k) {
			int[] flags = new int[input.length];
			for (int i = 0; i < k; i++) {
				int min = Integer.MAX_VALUE;
				int minIndex = 0;
				for (int j = 0; j < input.length; j++) {
					if (flags[j] == 0 && input[j] < min) {
						min = input[j];
						minIndex = j;
					}
				}
				flags[minIndex] = 1;
				list.add(min);
			}
		}
		return list;
	}

	/**
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列 2016-08-24
	 * 
	 * @param str
	 * @return
	 */
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str.length() == 0) {
			return result;
		} else if (str.length() == 1) {
			result.add(str);
			return result;
		}
		for (int i = 0; i < str.length(); i++) {

		}
		return result;
	}

	/**
	 * 求出1-n的n个整数中1出现的次数
	 * 
	 * 2016-08-24
	 * 
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			// 求出该数各个位上的数字
			int m = i;
			while (m != 0) {
				if (m % 10 == 1) {
					count++;
				}
				m = m / 10;
			}
		}
		return count;
	}

	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
	 * 
	 * @param numbers
	 * @return
	 */
	public String PrintMinNumber(int[] numbers) {

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation("aa");
	}

}
