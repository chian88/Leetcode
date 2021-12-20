package MinCostClimbingStairs;
import java.util.*;


class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < dp.length; i++) {
			int additionalCost = 0;
			if (i < cost.length) {
				additionalCost = cost[i];
			}

			dp[i] = Math.min(dp[i - 1] + additionalCost, dp[i - 2] + additionalCost);
		}

		return dp[dp.length - 1];
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		test.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
	}
}
// top down.
//class Solution {
//	int[] cost;
//	public int minCostClimbingStairs(int[] cost) {
//		this.cost = cost;
//		Integer[] dp = new Integer[cost.length + 1];
//		recursion(cost.length, dp);
//		return dp[dp.length - 1];
//	}
//
//	int recursion(int i, Integer[] dp) {
//		if (i == 0) {
//			int res = cost[0];
//			dp[i] = res;
//			return res;
//		}
//
//		if (i == 1) {
//			int res = cost[1];
//			dp[i] = res;
//			return res;
//		}
//
//
//		if (i == cost.length) {
//			int res = Math.min(recursion(i - 1, dp) , recursion(i - 2, dp));
//			dp[i] = res;
//			return res;
//		}
//
//		if (dp[i] != null) {
//			return dp[i];
//		}
//
//		int res = Math.min(recursion(i - 1, dp) + cost[i] , recursion(i - 2, dp) + cost[i]);
//		dp[i] = res;
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
//	}
//}

























//class Solution {
//	public int minCostClimbingStairs(int[] cost) {
//		int[] dp = new int[cost.length];
//
//		if (cost.length == 1) return cost[0];
//
//		if (cost.length == 2) return Math.min(cost[0], cost[1]);
//
//		dp[0] = cost[0];
//		dp[1] = cost[1];
//
//		for (int i = 2; i < cost.length; i++) {
//			dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
//		}
//
//		int res = Math.min(dp[dp.length - 2], dp[dp.length - 1]);
//
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
//	}
//}