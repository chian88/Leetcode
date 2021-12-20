package HouseRobber;
import java.util.*;

class Solution {
//	public int rob(int[] nums) {
//		int[] dp = new int[nums.length];
//
//		if (nums.length == 1) return nums[0];
//
//		dp[0] = nums[0];
//		dp[1] = Math.max(nums[0], nums[1]);
//
//		for (int i = 2; i < nums.length; i++) {
//			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
//		}
//
//		return dp[nums.length - 1];
//	}

	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		robHelper(nums, dp, nums.length - 1);

		return dp[nums.length - 1];
	}

	public int robHelper(int[] nums, int[] dp, int i) {
		if (i == 0) {
			dp[0] = nums[0];
			return nums[0];
		}
		if (i == 1) {
			dp[1] = Math.max(nums[0], nums[1]);
			return Math.max(nums[0], nums[1]);
		}

		if (dp[i] >= 0) return dp[i];

		dp[i] = Math.max(nums[i] + robHelper(nums, dp, i - 2), robHelper(nums, dp , i - 1));

		return dp[i];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.rob(new int[]{5,6,1,3,8,8,2,4});
	}
}