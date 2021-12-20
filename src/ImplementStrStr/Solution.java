package ImplementStrStr;
import java.util.*;


class Solution {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				boolean falsified = false;
				int j = 0;
				for (j = 0; (j < needle.length() && j + i < haystack.length() ); j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						falsified = true;
						break;
					}
				}

				if (!falsified && j == needle.length()) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.strStr("mississippi", "issipi");
	}
}