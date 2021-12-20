package GreatestSumDivisibleByThree;
import java.util.*;

class Solution {
	public int maxSumDivThree(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j< 3; j++) {
				if(i == 0) {
					int index = nums[i] % 3;
					dp[i][index] = Math.max(dp[i][index], nums[i]);
				} else {
					int index = (dp[i - 1][j] + nums[i]) % 3;
					dp[i][index] = Math.max(dp[i][index], dp[i - 1][j] + nums[i]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				}
			}
		}


		return dp[n-1][0];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSumDivThree(new int[]{3,6,5,1,8});
	}
}