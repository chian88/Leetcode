package ShortestPalindrome;
import java.util.*;

class Solution {
	public String shortestPalindrome(String s) {
		int n = s.length();
		int i = 0;

		for (int j = n - 1; j >= 0; j--) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
			}
		}

		if (i == n) {
			return s;
		}

		String remain_rev = s.substring(i, n);
		StringBuilder sb = new StringBuilder(remain_rev).reverse();

		return sb.toString() + shortestPalindrome(s.substring(0, i)) + s.substring(i);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.shortestPalindrome("abcbabcab");
	}
}



// KMP

//class Solution {
//	public String shortestPalindrome(String s) {
//		String temp = s + "#" + new StringBuilder(s).reverse().toString();
//		int[] table = getTable(temp);
//
//		return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
//	}
//
//	int[] getTable(String s) {
//		int[] table = new int[s.length()];
//
//		int index = 0;
//
//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(index) == s.charAt(i)) {
//				table[i] = table[i - 1] + 1;
//				index++;
//			} else {
//				index = table[i - 1];
//
//				while (index > 0 && s.charAt(index) != s.charAt(i)) {
//					index = table[index - 1];
//				}
//
//				if (s.charAt(index) == s.charAt(i)) {
//					index++;
//				}
//
//				table[i] = index;
//			}
//		}
//
//		return table;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.shortestPalindrome("abababc");
//	}
//}