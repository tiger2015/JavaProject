package test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner scanner = new Scanner(System.in); String result = ""; while
		 * (scanner.hasNextInt()) { int n = scanner.nextInt(); String inputStr =
		 * scanner.next(); if (inputStr.trim().length() > 0) { String[] array =
		 * inputStr.split(" "); int size = array.length; int count = 0; if (n ==
		 * 1) { count = 0; } else if (n == 2) { count = conbine(array[0],
		 * array[1]).size(); } else if (n == 3) { List<String> list =
		 * conbine(array[0], array[1]); for (int i = 0; i < list.size(); i++) {
		 * count += conbine(list.get(i), array[2]).size(); } } else if (n == 4)
		 * { List<String> list1 = conbine(array[0], array[1]); List<String>
		 * list2 = conbine(array[2], array[3]); for (int i = 0; i <
		 * list1.size(); i++) { for (int j = 0; j < list2.size(); j++) { count
		 * += conbine(list1.get(i), list2.get(j)).size(); } } } else if (n == 5)
		 * { List<String> list1 = conbine(array[0], array[1]); List<String>
		 * list2 = conbine(array[2], array[3]); for (int i = 0; i <
		 * list1.size(); i++) { for (int j = 0; j < list2.size(); j++) {
		 * List<String> list3 = conbine(list1.get(i), list2.get(j)); for (int m
		 * = 0; m < list3.size(); m++) { count += conbine(list3.get(m),
		 * array[4]).size(); } } } } else if (n == 6) { List<String> list1 =
		 * conbine(array[0], array[1]); List<String> list2 = conbine(array[2],
		 * array[3]); List<String> list3 = conbine(array[4], array[5]); for (int
		 * i = 0; i < list1.size(); i++) { for (int j = 0; j < list2.size();
		 * j++) { List<String> list4 = conbine(list1.get(i), list2.get(j));
		 * 
		 * for (int m = 0; m < list3.size(); m++) { for (int l = 0; l <
		 * list4.size(); l++) count += conbine(list3.get(m), list4.get(l))
		 * .size(); } } } } result += count + "\n"; }
		 * 
		 * } if (result.lastIndexOf('\n') > 0) {
		 * System.out.println(result.substring(0, result.lastIndexOf('\n'))); }
		 * else { System.out.println(result); }
		 */

		/*
		 * String arg1 = "013"; String arg2 = "012"; String arg3 = "0123";
		 * String arg4 = "123";
		 * 
		 * System.out.println(conbine(arg1, arg2, arg3, arg4));
		 */
		Scanner scanner = new Scanner(System.in);
		String result = "";
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			String inputStr = scanner.next();
			if (inputStr.trim().length() > 0) {
				String[] array = inputStr.split(" ");
				int size = array.length;
				int count = 0;
				List<List<String>> list = new ArrayList<List<String>>();
				for (int i = 0; i < size; i++) {
					List<String> subList = new ArrayList<String>();
					for (int j = 0; j < array[i].length(); j++) {
						subList.add(array[i].charAt(j) + "");
					}
					list.add(subList);
				}
				if (list.size() >= 2) {
					List<String> temp = conbine2(list.get(0), list.get(1));
					for (int i = 2; i < list.size(); i++) {
						temp = conbine2(temp, list.get(i));
					}
					result += temp.size() + "\n";
				} else if(list.size()==1){

					result += list.get(0).size() + "\n";
				}
			}
		}

		/*
		 * List<String> list1 = new ArrayList<String>(); list1.add("0");
		 * list1.add("1");
		 * 
		 * List<String> list2 = new ArrayList<String>(); list2.add("1");
		 * list2.add("2"); list2.add("3"); List<String> list3 = new
		 * ArrayList<String>(); list3.add("3"); list3.add("5"); List<String>
		 * list4 = new ArrayList<String>(); list4.add("5"); List<List<String>>
		 * list = new ArrayList<List<String>>(); list.add(list1);
		 * list.add(list2); list.add(list3); list.add(list4); List<String> temp
		 * = conbine2(list.get(0), list.get(1));
		 * 
		 * for (int i = 2; i < list.size(); i++) { temp = conbine2(temp,
		 * list.get(i)); }
		 */
		System.out.println(result.substring(0, result.lastIndexOf("\n")));
	}

	public static List<String> conbine(String... arg) {
		List<String> list = new ArrayList<String>();
		if (arg.length == 2) {
			for (int i = 0; i < arg[0].length(); i++) {
				for (int j = 0; j < arg[1].length(); j++) {
					String str = arg[0].charAt(i) + "" + arg[1].charAt(j);
					list.add(str);
				}
			}
		} else if (arg.length == 1) {
			List<String> list1 = new ArrayList<String>();
			for (int i = 0; i < arg[0].length(); i++) {
				for (int j = 0; j < list.size(); j++) {
					String str = list.get(j) + arg[0].charAt(i);
					list1.add(str);
				}
			}
			list = list1;
		} else {
			int index = arg.length / 2;
			String[] arg1 = new String[index];
			for (int i = 0; i < index; i++) {
				arg1[i] = arg[i];
			}
			conbine(arg1);
			String[] arg2 = new String[arg.length - index];
			for (int i = index; i < arg.length; i++) {
				arg2[i - index] = arg[i];
			}
			conbine(arg2);
		}
		return list;
	}

	public static List<String> conbine2(List<String> list1, List<String> list2) {
		List<String> list = new ArrayList<String>();
		for (String str1 : list1) {
			for (String str2 : list2) {
				int count = 0;
				for (int i = 0; i < str1.length(); i++) {

					if (str2.contains(str1.charAt(i) + "")) {
						count++;
						break;
					}
				}
				if (count == 0)
					list.add(str1 + str2);
			}
		}
		return list;
	}
}
