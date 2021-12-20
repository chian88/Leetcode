package MaximumScoreFromPerformingMultiplicationOperations;
import java.util.*;

class Solution {
	public int maximumScore(int[] nums, int[] multipliers) {
		int[][] dp = new int[multipliers.length + 1][multipliers.length + 1];
		int M = multipliers.length;
		for (int i = M - 1; i >= 0; i--) {
			for (int left = i; left >= 0; left--) {
				int right = nums.length - 1 - (i - left);
				dp[left][i] = Math.max( nums[left] * multipliers[i] + dp[left + 1][i + 1] ,
										nums[right] * multipliers[i] + dp[left][i + 1]);



			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maximumScore(new int[]{1,2,3}, new int[]{3,2,1});
	}
}
// top down.
//class Solution {
//	int[] nums;
//	int[] multiplier;
//
//	public int maximumScore(int[] nums, int[] multipliers) {
//		this.nums = nums;
//		this.multiplier = multipliers;
//		Integer[][] dp = new Integer[multipliers.length + 1][multipliers.length + 1];
//		recursion(0, 0, dp);
//	}
//
//	int recursion(int left, int i, Integer[][] dp) {
//		if (i == multiplier.length) {
//			return 0;
//		}
//
//		if (dp[left][i] != null) {
//			return dp[left][i];
//		}
//
//		int right = nums.length - 1 - (i - left);
//
//		int res = Math.max( nums[left] * multiplier[i] + recursion(left + 1, i + 1, dp),
//				nums[right] * multiplier[i] + recursion( left, i + 1, dp));
//
//		dp[left][i] = res;
//
//		return dp[left][i];
//	}
//}