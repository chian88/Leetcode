package MinimumCostToCutAStick;
import java.util.*;

class Solution {
	public int minCost(int n, int[] cuts) {
		Arrays.sort(cuts);
		int[] helper = new int[cuts.length + 2];
		helper[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = n;

		int[][] dp = new int[helper.length][helper.length];
		for (int i = 1; i < helper.length; i++) {
			for (int j = i - 1; j>= 0; j--) {
				if (i - j == 1) {
					dp[j][i] = 0;
				} else {
					dp[j][i] = Integer.MAX_VALUE;
					for (int k = j + 1; k < i; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i]);
					}
					dp[j][i] += helper[i] - helper[j];
				}
			}
		}
		return dp[0][helper.length - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minCost(7, new int[]{1,3,4,5});
	}
}