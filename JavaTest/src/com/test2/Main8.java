package com.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		List<Record> records = new ArrayList<Record>();
		while (true) {
			// 文件路径
			String path = scanner.next().trim();
			if (path.equals("end")) {
				break;
			}
			// 行号
			if (scanner.hasNextInt()) {
				int lineNumber = scanner.nextInt();
				if (path.length() > 0) {
					String fileName = path
							.substring(path.lastIndexOf('\\') + 1);
					if (list.contains(fileName)) {
						boolean flag = false;
						for (int i = 0; i < records.size(); i++) {
							if (records.get(i).lineNumber == lineNumber) {
								flag = true;
								records.get(i).errorCount++;
								break;
							}
						}
						if (!flag) {
							Record record = new Record(fileName, lineNumber);
							records.add(record);
							list.add(fileName);
						}
					} else {
						list.add(fileName);
						Record record = new Record(fileName, lineNumber);
						records.add(record);
					}
				}
			}
		}

		Record[] array = new Record[records.size()];
		for (int i = 0; i < records.size(); i++) {
			array[i] = records.get(i);
		}

		if (array.length - 1 > 0)
			Arrays.sort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (array[i].fileName.length() > 16) {
					System.out.print(array[i].fileName
							.substring(array[i].fileName.length() - 16));
				} else {
					System.out.print(array[i].fileName);
				}
				if (i == array.length - 1) {
					System.out.print(array[i].lineNumber + " "
							+ array[i].errorCount);
				} else {
					System.out.print(array[i].lineNumber + " "
							+ array[i].errorCount + "\n");
				}
			}
		}

	}
}

class Record implements Comparable<Record> {
	String fileName;
	int lineNumber;
	int errorCount;

	public Record(String fileName, int lineNumber) {
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		this.errorCount = 1;
	}

	@Override
	public int compareTo(Record o) {
		// TODO Auto-generated method stub
		if (o != null) {
			if (this.errorCount > o.errorCount) {
				return 1;
			} else if (this.errorCount < o.errorCount) {

				return -1;
			}
		}
		return 0;
	}

}