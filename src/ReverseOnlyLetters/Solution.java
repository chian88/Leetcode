package ReverseOnlyLetters;
import java.util.*;


class Solution {
	public String reverseOnlyLetters(String s) {
		StringBuilder reversed = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isLetter(s.charAt(i))) {
				reversed.append(s.charAt(i));
			}
		}

		StringBuilder ans = new StringBuilder();
		int ptr = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				ans.append(reversed.charAt(ptr));
				ptr++;
			} else {
				ans.append(s.charAt(i));
			}
		}

		return ans.toString();
	}
}