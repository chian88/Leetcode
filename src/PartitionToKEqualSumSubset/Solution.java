package PartitionToKEqualSumSubset;
import java.util.*;

class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		double target = sum * 1.0 / k;
		if (target != (int) target) {
			return false;
		}
		int target2 = (int) target;
		char[] dp = new char[nums.length];
		Map<String, Boolean> memo = new HashMap<>();
		boolean ans = recurse(nums, 0,0, k, dp, target2, memo);
		return ans;
	}

	boolean recurse(int[] nums, int soFar,  int currLevel, int k, char[] dp, int target, Map<String, Boolean> memo) {
		if (currLevel == k) {
			return true;
		}
		String dpStr = new String(dp);
		if (memo.containsKey(dpStr)) {
			return memo.get(dpStr);
		}

		for (int i = 0; i < nums.length; i++) {
			if (dp[i] == '1') {
				continue;
			}
			if (soFar + nums[i] == target) {
				dp[i] = '1';
				if (recurse(nums, 0, currLevel + 1, k, dp, target, memo)) {
					return true;
				}

				dp[i] = '0';

			} else if (soFar + nums[i] < target) {
				dp[i] = '1';
				if(recurse(nums, soFar + nums[i], currLevel, k, dp, target, memo)) {
					return true;
				}
				dp[i] = '0';
			}

		}

		memo.put(dpStr, false);

		return false;
	}

	public static void main(String[] args) {
		boolean[] taken = new boolean[2];
		taken[0] = true;

		Solution test = new Solution();
		test.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4);


	}
}