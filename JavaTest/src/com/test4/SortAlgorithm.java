package com.test4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortAlgorithm {

	/**
	 * 冒泡排序 找到排序后每个位置上的元素，每次都能够找到一个位置上的元素
	 * 
	 * @param array
	 *            排序数组
	 * @return
	 */
	public static <T extends Comparable<T>> T[] bulleSort(T[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				// 升序排列
				boolean exchanged = false;
				if (array[i].compareTo(array[j]) > 0) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					exchanged = true;
				}
				if (!exchanged) {
					break;
				}
			}
		}
		return array;
	}

	/**
	 * 选择排序 每次选择待排中最小的元素
	 * 
	 * @param array
	 *            待排元素
	 * @return
	 */
	public static <T extends Comparable<T>> T[] selectionSort(T[] array) {

		int size = array.length;
		for (int i = 0; i < size; i++) {
			int minIndex = i;
			T minT = array[minIndex];
			// 每次找到下一个最小的元素
			for (int j = i; j < size; j++) {
				if (minT.compareTo(array[j]) > 0) {
					minIndex = j;
					minT = array[j];
				}
			}
			T temp = array[i];
			array[i] = minT;
			array[minIndex] = temp;
		}

		return array;
	}

	/**
	 * 插入排序
	 * 
	 * @param array
	 *            待排元素集合
	 * @return
	 */
	public static <T extends Comparable<T>> T[] insertSort(T[] array) {
		int size = array.length;
		for (int i = 1; i < size; i++) {
			T temp = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp.compareTo(array[j]) < 0) {
					array[j+1] = array[j];
				} else {
					array[j + 1] = temp;
					break;
				}
			}
		}

		return array;
	}

	/**
	 * 归并排序：采用分治的方法 二路归并排序
	 * 
	 * @param array
	 * @param left
	 *            开始下标
	 * @param right
	 *            结束下标
	 * @return
	 */
	public static <T extends Comparable<T>> T[] mergeSort(T[] array, int left,
			int right, Class<T> type) {
		if (left >= right)
			return array;
		int center = (left + right) / 2;
		// 左部分排序
		mergeSort(array, left, center, type);
		// 右部分排序
		mergeSort(array, center + 1, right, type);
		// 合并
		merge(array, left, center + 1, right, type);
		return array;
	}

	/**
	 * 两个有序表合并
	 * 
	 * @param array
	 * @param left
	 *            第一个有序表的开始下标
	 * @param center
	 *            第二个有序表的开始下标
	 * @param right
	 *            第二个有序表的结束下标
	 */
	private static <T extends Comparable<T>> void merge(T[] array, int left,
			int center, int right, Class<T> type) {
		// 保存合并后的结果
		// 相邻的合并
		// Object[] tmp = (T[]) new Object[right - left + 1];
		T[] tmp = (T[]) Array.newInstance(type, right - left + 1);
		int i = left, j = center, k = 0;

		while (i < center && j <= right) {
			if (array[i].compareTo(array[j]) <= 0) {
				tmp[k] = array[i];
				k++;
				i++;
			} else {
				tmp[k] = array[j];
				j++;
				k++;
			}
		}
		while (i < center) {
			tmp[k] = array[i];
			i++;
			k++;
		}
		while (j <= right) {
			tmp[k] = array[j];
			j++;
			k++;
		}
		System.arraycopy(tmp, 0, array, left, tmp.length);
	}

	/**
	 * 希尔排序 对有间隔的元素进行排序 常用的间隔有： h = 3 * h +1，增量为h
	 * 
	 * @param array
	 * @return
	 */
	public static <T extends Comparable<T>> T[] shellSort(T[] array) {
		int h = 1;
		int size = array.length;
		while (h <= size / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (int i = h; i < size; i += h) {

				T temp = array[i];
				for (int j = i-h; j >= 0; j -= h) {
					if (temp.compareTo(array[j]) < 0) {
						array[j+h] = array[j];
					} else {
						//array[j+h] = array[j];
						array[j+h] = temp;
						break;
					}
				}
			}
			h = (h - 1) / 3;
		}
		return array;
	}

	public static void main(String[] args) {
		Integer[] array = { 2, 5, 4, 9, 63, 45, 25, 41 };
		SortAlgorithm.shellSort(array);

		System.out.println(Arrays.toString(array));

	}

}
