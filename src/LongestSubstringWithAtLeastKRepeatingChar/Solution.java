package LongestSubstringWithAtLeastKRepeatingChar;
import java.util.*;


class Solution {
	public int longestSubstring(String s, int k) {
		int ans = recursion(s, k, 0, s.length());
		return ans;
	}

	int recursion(String s, int k, int lo, int hi) {
		if (hi <= lo) {
			return 0;
		}
		int[] counter = new int[26];
		for (int i = lo; i < hi; i++) {
			counter[s.charAt(i) - 'a']++;
		}

		for (int i = lo; i < hi; i++) {
			if (counter[s.charAt(i) - 'a'] < k) {
				// break here;
				int left = recursion(s, k, lo, i);
				int right = recursion(s, k, i + 1, hi);
				return Math.max(left,right);
			}
		}

		return (hi - lo);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestSubstring("ababcabaaadc", 2);
	}
}