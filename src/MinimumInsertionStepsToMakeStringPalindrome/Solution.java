package MinimumInsertionStepsToMakeStringPalindrome;
import java.util.*;

class Solution {
	public int minInsertions(String s) {
		Integer[][] dp = new Integer[s.length()][s.length()];
		int ans = recursion(0, s.length() - 1, s, dp);
		return ans;
	}

	int recursion(int left, int right, String s, Integer[][] dp) {
		if (right <= left) {
			return 0;
		}
		if (dp[left][right] != null) {
			return dp[left][right];
		}

		int min = Integer.MAX_VALUE;

		if (s.charAt(left) == s.charAt(right)) {
			min = Math.min(min, 0 + recursion(left + 1, right - 1, s, dp));
		} else {
			min = Math.min(min, 1 + Math.min(recursion(left + 1, right, s, dp), recursion(left, right - 1, s, dp)));
		}

		dp[left][right] = min;

		return min;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minInsertions("mbadm");
	}
}