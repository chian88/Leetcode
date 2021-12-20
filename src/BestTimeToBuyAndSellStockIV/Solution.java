package BestTimeToBuyAndSellStockIV;
import java.util.*;

class Solution {
	int[] prices;

	public int maxProfit(int k, int[] prices) {
		this.prices = prices;
		Integer[][][] dp = new Integer[prices.length + 1][k + 1][2];
		int profit = recursion(0, k, false, dp);
		return profit;
	}

	int recursion(int day, int k, boolean holdStock, Integer[][][] dp) {
		if (day == prices.length || (k == 0 && holdStock == false) ) {
			return 0;
		}

		if (dp[day][k][holdStock == true ? 1 : 0] != null)  {
			return dp[day][k][holdStock == true ? 1 : 0];
		}

		int currProfit = 0;
		if (holdStock) {
			currProfit = Math.max( recursion(day + 1 , k, false, dp) + prices[day],
								recursion(day + 1 , k, true, dp));
		} else {
			currProfit = Math.max( recursion(day + 1, k - 1, true, dp)  - prices[day],
								recursion( day + 1,  k, false, dp));
		}

		dp[day][k][holdStock == true ? 1 : 0] = currProfit;

		return currProfit;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxProfit(2, new int[]{3,2,6,5,0,3});
	}
}