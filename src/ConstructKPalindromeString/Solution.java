package ConstructKPalindromeString;
import java.util.*;


class Solution {
	public boolean canConstruct(String s, int k) {
		if (s.length() < k) {
			return false;
		}
		int[] counter = new int[26];

		for (char c : s.toCharArray()) {
			counter[c - 'a']++;
		}
		int odd = 0;

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] % 2 == 1) {
				odd++;
			}
		}

		return odd <= k;

	}
}