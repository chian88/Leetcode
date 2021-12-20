package EggDropWith2EggsAndNFloors;
import java.util.*;

class Solution {
	public int twoEggDrop(int n) {
		Integer[][] dp = new Integer[3][n + 1];
		return recursion(n, 2, dp);
	}

	int recursion(int n, int eggLeft, Integer[][] dp) {
		if (dp[eggLeft][n] != null) {
			return dp[eggLeft][n];
		}

		if (eggLeft == 1) {
			return n;
		}

		if (n <= 1) {
			return n;
		}
		int min = Integer.MAX_VALUE;
		for (int x = 1; x < n; x++) {
			min = Math.min(min, Math.max(recursion(x - 1, eggLeft - 1, dp), recursion(n - x, eggLeft, dp)) + 1);
		}

		dp[eggLeft][n] = min;

		return min;
	}
}