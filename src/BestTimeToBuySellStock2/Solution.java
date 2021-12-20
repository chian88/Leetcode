package BestTimeToBuySellStock2;
import java.util.*;

class Solution {
	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][prices.length];

		int i = 0;
		int j = 0;

		int offset = 0;

		while (offset != prices.length) {
			if (i == j) {
				dp[i][j] = 0;
			} else {
				dp[i][j] = Math.max(0, prices[j] - prices[i]);
				dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]);
			}
			i += 1;
			j += 1;

			if (i == prices.length - offset) {
				offset += 1;
				i = 0;
				j = offset;
			}
		}

		return dp[0][prices.length - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxProfit(new int[]{7,1,5,3,6,4});
	}
}