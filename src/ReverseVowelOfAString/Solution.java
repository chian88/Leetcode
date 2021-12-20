package ReverseVowelOfAString;
import java.util.*;

class Solution {
	public String reverseVowels(String s) {
		int start = 0;
		int end = s.length() - 1;
		char[] chars = s.toCharArray();
		while (start < end) {
			boolean firstLetterVowel = isVowel(s, start);
			boolean secondLetterVowel = isVowel(s, end);
			if (firstLetterVowel && secondLetterVowel) {
				char temp = chars[start];
				chars[start] = chars[end];
				chars[end] = temp;
				start++;
				end--;
			} else if (firstLetterVowel) {
				end --;
			} else if (secondLetterVowel) {
				start ++;
			} else {
				start++;
				end--;
			}

		}

		return new String(chars);
	}

	boolean isVowel(String s, int idx) {
		return s.charAt(idx) == 'a' || s.charAt(idx) == 'e' || s.charAt(idx) == 'i' || s.charAt(idx) == 'o' || s.charAt(idx) == 'u' ||
		s.charAt(idx) == 'A' || s.charAt(idx) == 'E' || s.charAt(idx) == 'I' || s.charAt(idx) == 'O' || s.charAt(idx) == 'U' ;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.reverseVowels("hello");
	}
}
