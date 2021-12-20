package MinimumTotalSpaceWastedWithKResizingOperations;
import java.util.*;


class Solution {
	int[] nums;
	public int minSpaceWastedKResizing(int[] nums, int k) {
		return (int) solve(0, k, nums, new Long[nums.length][k+1]);
	}

	long solve(int start, int k, int[] nums, Long[][] dp) {
		if (start == nums.length) return 0;
		if (k == -1) return Integer.MAX_VALUE;
		if (dp[start][k] != null) return dp[start][k];

		long ans = Long.MAX_VALUE;

		int max = nums[start], sum = 0;

		for (int i = start; i < nums.length; i++) {
			max = Math.max(nums[i], max);
			sum += nums[i];
			ans = Math.min(ans, ((i - start + 1) * max - sum) + solve(i + 1, k -1, nums, dp));
		}

		return dp[start][k] = ans;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.minSpaceWastedKResizing(new int[]{10,20,15,30,20}, 2);
	}
}