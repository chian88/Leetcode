package WildcardMatching;
import java.util.*;

class Solution {
	int n;
	int m;
	String s;
	String p;

	public boolean isMatch(String s, String p) {
		this.n = s.length();
		this.m = p.length();
		this.s = s;
		this.p = p;

		if (s.isEmpty() && allAsterisk(p)) {
			return true;
		}


		Boolean[][] dp = new Boolean[n+1][m+1];
		boolean res = recursion(0, 0, dp);
		return res;
	}

	boolean allAsterisk(String p) {
		boolean res = true;
		for (char c : p.toCharArray()) {
			if (c != '*') {
				res = false;
			}
		}

		return res;
	}

	boolean allAstrerskFromThisOnward(String p, int j) {
		boolean res = true;
		for (; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				res = false;
			}
		}

		return res;
	}

	boolean recursion(int i, int j, Boolean[][] dp) {
		if (i == n && allAstrerskFromThisOnward(p, j)) {
			return true;
		} else if (i == n && j == m) {
			return true;
		} else if (i == n && j < m) {
			return false;
		} else if (i < n && j == m) {
			return false;
		}
		if (dp[i][j] != null) {
			return dp[i][j];
		}

		if (p.charAt(j) == '*') {
			boolean res = recursion(i + 1, j, dp) || recursion(i + 1, j + 1, dp) || recursion(i, j + 1, dp);
			dp[i][j] = res;
			return res;
		} else if (p.charAt(j) == '?') {
			boolean res = recursion(i + 1, j + 1, dp);
			dp[i][j] = res;
			return res;
		} else if (s.charAt(i) == p.charAt(j)) {
			// matches
			boolean res = recursion(i + 1, j + 1, dp);
			dp[i][j] = res;
			return res;
		} else  {
			boolean res = false;
			dp[i][j] = res;
			return res;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.isMatch("abcabczzzde", "*abc???de*");
	}
}