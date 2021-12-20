package LongestCommonSubsequence;
import java.util.*;

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i -1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}

			}
		}

		return dp[dp.length -1][dp[0].length -1 ];
	}
}


// top down.


//class Solution {
//	String text1;
//	String text2;
//	public int longestCommonSubsequence(String text1, String text2) {
//		this.text1 = text1;
//		this.text2 = text2;
//		Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 1];
//		int ans = recursion(text1.length(), text2.length(),  dp);
//
//		return ans;
//	}
//
//	int recursion(int i, int j, Integer[][] dp) {
//		if (i == 0 || j == 0) {
//			return 0;
//		}
//
//		if (dp[i][j] != null) {
//			return dp[i][j];
//		}
//
//		int res = 0;
//		if (text1.charAt(i-1) == text2.charAt(j-1)) {
//			res = recursion(i - 1, j - 1, dp) + 1;
//		} else {
//			res = Math.max(recursion(i - 1, j, dp), recursion(i, j - 1, dp));
//		}
//
//		dp[i][j] = res;
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.longestCommonSubsequence("bl", "yby");
//	}
//}
//























//class Solution {
//	public int longestCommonSubsequence(String text1, String text2) {
//		int longest = 0;
//		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//		longest = recurse(text1, text2, text1.length() - 1, text2.length() - 1, dp);
//
//
//		return longest;
//	}
//
//	int recurse(String text1, String text2, int i , int j, int[][] dp) {
//		if (dp[i + 1][j + 1] > 0) return dp[i + 1][j + 1];
//
//		if (i < 0) {
//			return 0;
//		}
//		if (j < 0)  {
//			return 0;
//		}
//		if (text1.charAt(i) == text2.charAt(j)) {
//			int res = recurse(text1, text2, i - 1, j - 1, dp) + 1;
//			dp[i + 1][j + 1] = Math.max(res, dp[i + 1][j + 1]);
//			return dp[i + 1][j + 1];
//		} else {
//			int res = Math.max(recurse(text1, text2, i - 1, j, dp), recurse(text1, text2, i, j -1 , dp));
//			dp[i + 1][j + 1] = Math.max(res,dp[i + 1][j + 1]) ;
//			return dp[i + 1][j + 1];
//		}
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.longestCommonSubsequence("ezupkr", "ubmrapg");
//	}
//}