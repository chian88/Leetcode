package InterleavingString;
import java.util.*;

class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

		boolean ans = recursion(s1, s2, s3, 0, 0, 0, dp);
		return ans;
	}

	boolean recursion(String s1, String s2, String s3, int s1Idx, int s2Idx, int s3Idx, Boolean[][] dp) {

		if (dp[s1Idx][s2Idx] != null) {
			return dp[s1Idx][s2Idx];
		}

		if (s3Idx == s3.length() && s2Idx == s2.length() && s1Idx == s1.length()) {
			return true;
		}

		if (s1Idx < s1.length() && s3Idx < s3.length() &&  s1.charAt(s1Idx) == s3.charAt(s3Idx)) {
			boolean res = recursion(s1,s2,s3, s1Idx+1, s2Idx, s3Idx + 1, dp);
			if (res) {
				return true;
			}
		}

		if (s2Idx < s2.length() && s3Idx < s3.length() && s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
			boolean res = recursion(s1,s2,s3, s1Idx, s2Idx + 1, s3Idx + 1, dp);
			if (res) {
				return true;
			}
		}
		dp[s1Idx][s2Idx] = false;
		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.isInterleave("aabcc", "dbbca", "aadbbcbcac");

	}
}