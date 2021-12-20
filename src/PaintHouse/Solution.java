package PaintHouse;
import java.util.*;

class Solution {
	public int minCost(int[][] costs) {
		int[][] dp = new int[3][costs.length];
		int nas = recursion(costs, 0, -1, dp);
		return nas;
	}

	int recursion(int[][] costs, int idx, int ban, int[][] dp) {
		if (idx >= costs.length) {
			return 0;
		}

//		if (ban != -1 && dp[ban][idx] != 0) {
//			return dp[ban][idx];
//		}

		int[] cost = costs[idx];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < cost.length; i++) {
			if (i == ban) {
				continue;
			}
			min = Math.min(min, cost[i] + recursion(costs, idx + 1, i, dp));

		}
//		if (ban != -1) {
//			dp[ban][idx] = min;
//		}

		return min;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minCost(new int[][]{{17,2,17}, {16,16,5}, {14,3,19}});
	}
}