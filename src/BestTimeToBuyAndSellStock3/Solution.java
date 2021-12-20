package BestTimeToBuyAndSellStock3;
import java.util.*;

class Solution {
	int[] prices;
	public int maxProfit(int[] prices) {
		this.prices = prices;
		Integer[][][] dp = new Integer[prices.length + 1][3][2];
		int ans = recursion(0, 2, false, dp);
		return ans;
	}

	int recursion(int i, int k, boolean holding, Integer[][][] dp) {
		if (i == prices.length || (k == 0 && holding == false)) {
			return 0;
		}

		if (dp[i][k][holding == true ? 1 : 0] != null) {
			return dp[i][k][holding == true ? 1 : 0];
		}

		int res = 0;
		if (holding) {
			// already hold, sell or skip
			res = Math.max( recursion(i + 1, k, false, dp) + prices[i] ,
							recursion(i + 1, k, true, dp));
		} else {
			// don't hold, skip or buy.
			res = Math.max( recursion(i + 1, k - 1, true, dp) - prices[i] ,
							recursion(i + 1, k, false, dp) );
		}
		dp[i][k][holding == true ? 1 : 0] = res;
		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxProfit(new int[]{3,3,5,0,0,3,1,4});
	}
}