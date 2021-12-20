package WordBreak2;
import java.util.*;

class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		Set<String> wordSet = new HashSet<>(wordDict);
		List<String> str = new ArrayList<>();
		Boolean[][] dp = new Boolean[s.length() + 1][s.length() + 1];
		recursion(s, 0, 1, str, wordSet, res, dp);
		return res;
	}

	boolean recursion(String s, int start, int end, List<String> str, Set<String> wordDict, List<String> res , Boolean[][] dp) {
		if (start == s.length()) {
			res.add(String.join(" ", str));

			return true;
		}

		if (dp[start][end - 1] != null) {
			return dp[start][end - 1];
		}

		while (end <= s.length()) {
			String subStr = s.substring(start, end);

			if (wordDict.contains(subStr)) {
				str.add(subStr);
				recursion(s, end, end + 1, str, wordDict, res, dp);
				str.remove(str.size() - 1);
			}

			end++;
		}

		dp[start][end - 1] = false;
		return false;
	}

	public static void main(String[] args) {

		Solution test = new Solution();
		test.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
	}
}