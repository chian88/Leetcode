package LongestPalindromicSubsequence;
import java.util.*;


class Solution {
	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];


		int row = 0;
		int col = 0;
		int offset = 0;

		while (offset < s.length()) {
			if (row == col) {
				dp[row][col] = 1;
			} else if ( Math.abs(col - row) == 1 ){
				if (s.charAt(row) == s.charAt(col)) {
					dp[row][col] = 2;
				} else {
					dp[row][col] = 1;
				}
			} else {
				if (s.charAt(row) == s.charAt(col)) {
					dp[row][col] = 2 + dp[row + 1][col - 1];
				} else {
					dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
				}
			}
			row++;
			col++;

			if (row == dp.length - offset) {
				offset ++;
				row = 0;
				col = offset;
			}
		}

		return dp[0][s.length() - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestPalindromeSubseq("agbdba");
	}
}
