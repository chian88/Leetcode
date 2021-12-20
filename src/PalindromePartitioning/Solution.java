package PalindromePartitioning;
import java.util.*;

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();

		partitionHelper(s, 0, res, new ArrayList<>());
		return res;
	}

	void partitionHelper(String s, int start, List<List<String>> res, List<String> currRes) {
		if (start >= s.length()) {
			res.add(new ArrayList<>(currRes));
			return;
		}

		for (int end = start; end < s.length(); end ++) {
			if (isPalindrome(s, start, end)) {
				currRes.add(s.substring(start, end + 1));
				partitionHelper(s, end + 1, res, currRes);
				currRes.remove(currRes.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}

		return true;
	}
}