package WordBreak;
import java.util.*;

class Solution {
	String s;
	Set<String> wordSet;
	public boolean wordBreak(String s, List<String> wordDict) {
		this.wordSet = new HashSet<>();
		this.s = s;

		Boolean[] dp = new Boolean[s.length()];
		for (String word : wordDict) {
			wordSet.add(word);
		}

		return recursion(0, dp);
	}

	boolean recursion(int start, Boolean[] dp) {

		if (start >= s.length()) {
			return true;
		}

		if (dp[start] != null) {
			return dp[start];
		}

		for (int end = start + 1; end <= s.length(); ++end) {
			String subStr = s.substring(start, end);

			if (wordSet.contains(subStr)) {
				boolean next = recursion(end, dp);
				if (next) {
					dp[start] = true;
					return true;
				}
			}
		}
		dp[start] = false;
		return false;
	}
}