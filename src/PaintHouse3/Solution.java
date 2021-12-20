package PaintHouse3;
import java.util.*;

class Solution {
	int max = 100000008;
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
		Integer[][][] dp = new Integer[m + 1][n + 1][target + 1] ;
		int ans = recursion(houses, cost, target, 0, 0, dp, m, n);
		ans = ans == max ? -1 : ans;
		return ans;
	}

	int recursion(int[] houses, int[][] cost, int target, int idx, int prevChoice, Integer[][][] dp, int m, int n) {
		if (target < 0) {
			return max;
		}

		if (idx == m && target == 0) {
			return 0;
		} else if (idx == cost.length) {
			return max;
		}

		if (dp[idx][prevChoice][target] != null) {
			return dp[idx][prevChoice][target];
		}


		if (houses[idx] != 0) {
			int res = 0;

			if (houses[idx] == prevChoice) {
				res = recursion(houses, cost, target, idx + 1, houses[idx] , dp, m, n);
			} else {
				res = recursion(houses, cost, target - 1, idx + 1, houses[idx], dp, m , n);
			}

			dp[idx][prevChoice][target] = res;
			return dp[idx][prevChoice][target];
		}

		int[] choices = cost[idx];
		int min = max;
		for (int i = 0; i < choices.length; i++) {
			int res = 0;

			if (i + 1 == prevChoice) {
				res = recursion(houses, cost, target, idx + 1, i + 1, dp, m, n);
			} else {
				res = recursion(houses, cost, target - 1, idx + 1, i + 1, dp, m, n);
			}

			min = Math.min(min, res + choices[i]);
		}


		return dp[idx][prevChoice][target] = min;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minCost(new int[]{0,0,0,0,0}, new int[][]{{1,10}, {10,1}, {10,1}, {1,10}, {5,1}}, 5, 2, 3);
	}
}