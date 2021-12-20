package PartitionArrayForMaximumSum;
import java.util.*;


class Solution {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length + 1];
		dp[0] = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= k && i - j >= 0; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + findMax(i, j, arr) * j);
			}

		}

		return dp[dp.length - 1];
	}

	int findMax(int i, int j, int[] arr ) {
		int max = arr[i - 1];
		for (int offset = 1 ; offset <= j; offset++ ) {
			max = Math.max(max, arr[i - offset]);
		}

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
	}
}