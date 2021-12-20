package CoinChange2;
import java.util.*;


class Solution {
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = 1;
				} else {
					if (coins[i - 1] <= j) {
						dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[dp.length- 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.change(5, new int[]{1,2,5});
	}
}