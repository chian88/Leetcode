package CoinChange;

import java.util.Collections;
import java.util.*;

class Solution {
	public static int coinChange(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int toCompare = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				if (coins[i] <= j) {

					if (dp[j - coins[i]] == Integer.MAX_VALUE) {
						toCompare = Integer.MAX_VALUE;
					} else {
						toCompare = dp[j - coins[i]] + 1;

					}

					dp[j] = Math.min(dp[j], toCompare);
				}
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		coinChange(new int[]{2}, 3);
	}

}