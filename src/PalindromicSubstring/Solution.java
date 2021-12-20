package PalindromicSubstring;
import java.util.*;

class Solution {
	public int countSubstrings(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int res = 0;
		int i = 0;
		int j = 0;
		int offset = 0;
		while (i != 0 || j != s.length()) {
			if (j == i) {
				res += 1;
				dp[i][j] = true;
			} else if (s.charAt(i) == s.charAt(j) && Math.abs(j - i) < 2) {
				res += 1;
				dp[i][j] = true;
			} else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
				res += 1;
				dp[i][j] = true;
			}


			if (i == s.length() - 1 - offset) {
				offset += 1;
				i = 0;
				j = 0 + offset;

			} else {
				i += 1;
				j += 1;
			}



		}



		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countSubstrings("acbca");
	}
}