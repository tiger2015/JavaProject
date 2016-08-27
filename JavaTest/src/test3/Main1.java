package test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String result = "";
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			List<List<String>> list = new ArrayList<List<String>>();
			for (int i = 0; i < n; i++) {
				String inputStr = scanner.next().trim();
				List<String> subList = new ArrayList<String>();
				for (int j = 0; j < inputStr.length(); j++) {
					subList.add(inputStr.charAt(j) + "");
				}
				list.add(subList);
			}
			if (list.size() >= 2) {
				List<String> temp = conbine(list.get(0), list.get(1));
				for (int i = 2; i < list.size(); i++) {
					temp = conbine(temp, list.get(i));
				}
				result += temp.size() + "\n";
			} else if (list.size() == 1) {
				result += list.get(0).size() + "\n";
			}
		}
		System.out.println(result.substring(0, result.lastIndexOf("\n")));
	}

	public static List<String> conbine(List<String> list1, List<String> list2) {
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
