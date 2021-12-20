package ReverseWordsInAStringIII;
import java.util.*;
class Solution {
	public static String reverseWords(String s) {
		int start = 0;
		int end = 0;

		while (end < s.length()) {
			if (Character.isWhitespace(s.charAt(end)) ) {
				s = reverseWord(s, start, end - 1);

				end++;
				start = end;
			} else {
				end++;
			}
		}
		s = reverseWord(s, start, end - 1);
		return s;
	}

	private static String reverseWord(String s, int begin, int end) {
		StringBuilder res = new StringBuilder(s);


		while (begin < end) {
			char temp = res.charAt(begin);
			res.setCharAt(begin, res.charAt(end));
			res.setCharAt(end, temp);
			begin++;
			end--;
		}

		return res.toString();
	}

	public static void main(String[] args) {
		reverseWords("Let's take LeetCode contest");
	}
}