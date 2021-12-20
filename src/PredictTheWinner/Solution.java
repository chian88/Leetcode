package PredictTheWinner;
import java.util.*;

class Solution {
	public boolean PredictTheWinner(int[] nums) {
		int sum = 0;

		for (int num : nums) {
			sum += num;
		}
		int[][] dp = new int[nums.length][nums.length];

		int ans = recurse(nums, 0, nums.length - 1, dp);

		int opp = sum - ans;

		return ans >= opp;

	}

	int recurse(int[] nums, int left, int right, int[][] dp ) {
		if (right < left) {
			return 0;
		}

		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		int takeLeft = nums[left] + Math.min(recurse(nums, left + 1, right - 1, dp) , recurse(nums, left + 2, right, dp));

		int takeRight = nums[right] + Math.min(recurse(nums, left, right - 2, dp), recurse(nums, left + 1, right - 1, dp));

		dp[left][right] = Math.max(takeLeft, takeRight);

		return Math.max(takeLeft, takeRight);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.PredictTheWinner(new int[]{1,5,233,7});
	}
}