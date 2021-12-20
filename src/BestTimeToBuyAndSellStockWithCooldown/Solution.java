package BestTimeToBuyAndSellStockWithCooldown;
import java.util.*;

class Solution {
	int[] prices;

	public int maxProfit(int[] prices) {
		this.prices = prices;
		Integer[][] dp = new Integer[prices.length + 1][2];

		int ans = recursion(0, null, 2, dp);

		return ans;
	}

	int recursion(int i , Integer price, int cooldown, Integer[][] dp) {
		if (i >= prices.length) {
			return 0;
		}
		if (dp[i][price == null ? 0 : 1] != null) {
			return dp[i][price == null ? 0 : 1];
		}


		int max = Integer.MIN_VALUE;
		if (price == null) {
			if (cooldown > 1) {
				max = Math.max(recursion(i + 1, null, cooldown + 1, dp) , // don't buy
						recursion(i + 1, prices[i], cooldown + 1, dp) );  // buy
			} else {
				// don't buy
				max =  recursion(i + 1, null, cooldown + 1, dp);
			}

		} else {
			max = Math.max(prices[i] - price + recursion( i + 1, null, 1, dp), // sell.
					recursion(i + 1, price, cooldown + 1, dp)); // don't sell.

		}
		dp[i][price == null ? 0 : 1] = max;

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxProfit(new int[]{1,2,3,0,2});
	}
}