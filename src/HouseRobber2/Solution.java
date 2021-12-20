package HouseRobber2;
import java.util.*;


class Solution {
	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];

		int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
		int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
		return Math.max(rob2(nums1), rob2(nums2));
	}

	public int rob2(int[] nums) {
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