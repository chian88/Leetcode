package ReorderLogFiles;
import java.util.*;

class Solution {


	public static String[] reorderLogFiles(String[] logs) {
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] arr1 = o1.split(" ", 2);
				String[] arr2 = o2.split(" ", 2);

				if (!Character.isDigit(arr1[1].charAt(0))  && !Character.isDigit(arr2[1].charAt(0))) {
					// both not digit.
					int comp = arr1[1].compareTo(arr2[1]);

					if (comp != 0) return comp;

					return arr1[0].compareTo(arr1[1]);

				} else if (!Character.isDigit(arr1[1].charAt(0))  && Character.isDigit(arr2[1].charAt(0))) {
					// first string is digit
					return -1;
				} else if (Character.isDigit(arr1[1].charAt(0))  && !Character.isDigit(arr2[1].charAt(0))) {
					// second string is digit.
					return 1;
				} else {
					return 0;
				}
			}
		};

		Arrays.sort(logs, comp);


		return logs;
	}

	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

		reorderLogFiles(logs);
	}
}