package MaximumSubarray;

class Solution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				dp[i] = nums[i];
				max = dp[i];
				continue;
			}

			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

			max = Math.max(max, dp[i]);
		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}
}