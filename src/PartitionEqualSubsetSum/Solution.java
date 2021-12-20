package PartitionEqualSubsetSum;
import java.util.*;


class Solution {
	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		Boolean[][] dp = new Boolean[target + 1][nums.length];
		boolean ans = recurse(target, nums, nums.length - 1, dp);

		return ans;
	}

	boolean recurse(int target, int[] nums, int currIdx, Boolean[][] dp) {
		if (target < 0) {
			return false;
		}

		if (target == 0) {
			return true;
		}

		if (currIdx < 0) {
			return false;
		}

		if (dp[target][currIdx] != null) {
			return dp[target][currIdx];
		}

		boolean first = recurse(target - nums[currIdx], nums, currIdx - 1, dp);
		boolean second = recurse(target, nums, currIdx - 1, dp);

		dp[target][currIdx] = (first || second);

		return (first || second);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canPartition(new int[]{1,5,11,5});
	}

}