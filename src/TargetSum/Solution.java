package TargetSum;
import java.util.*;


class Solution {
	int[] nums;
	int target;
	public int findTargetSumWays(int[] nums, int target) {
		this.nums = nums;
		this.target = target;
		int ans = dfs(0, 0);
		return ans;
	}

	int dfs(int i, int sum) {
		if (i == nums.length && sum == target) {
			return 1;
		} else if (i == nums.length) {
			return 0;
		}

		int res = dfs(i + 1, sum + nums[i]) + dfs(i + 1, sum - nums[i]);

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
	}
}




//class Solution {
//	public int findTargetSumWays(int[] nums, int target) {
//		int total = Arrays.stream(nums).sum();
//
//		int[][] dp = new int[nums.length][2 * total + 1];
//
//		for (int[] row : dp) {
//			Arrays.fill(row, Integer.MIN_VALUE);
//		}
//
//		int ans = backtracking(nums, target, 0, 0, total, dp);
//		return ans;
//	}
//
//	int backtracking(int[] nums, int target, int currSum, int idx, int total, int[][] dp) {
//		int ways = 0;
//		if (idx == nums.length && currSum == target) {
//			return 1;
//		} else if (idx == nums.length) {
//			return 0;
//		}
//
//		if (dp[idx][currSum + total] != Integer.MIN_VALUE) {
//			return dp[idx][currSum + total];
//		}
//
//
//		ways += backtracking(nums, target, currSum + nums[idx], idx + 1, total, dp);
//		ways += backtracking(nums, target, currSum - nums[idx], idx + 1, total, dp);
//
//		dp[idx][currSum + total] = ways;
//
//		return ways;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
//	}
//}