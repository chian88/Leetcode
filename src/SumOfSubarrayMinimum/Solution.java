package SumOfSubarrayMinimum;
import java.util.*;

class Solution {
	public int sumSubarrayMins(int[] arr) {
		int[][] dp = new int[arr.length + 1][arr.length + 1];

		int start = 1;
		int end = 1;

		int k = 0;

		while (k < arr.length) {
			start = 1;
			end = 1 + k;
			while (start < dp.length && end < dp.length) {
				if (start == end) {
					dp[start][end] = arr[start - 1];
				} else if (start < end) {
					int minB = Integer.MAX_VALUE;
					for (int i = start - 1; i < end; i++) {
						minB = Math.min(minB, arr[i]);
					}

					dp[start][end] = ( dp[start + 1][end] + dp[start][end - 1] - dp[start + 1][end - 1] + minB)  % 1000000007;
				}
				start += 1;
				end += 1;
			}
			k++;
		}


		return (int) dp[1][dp[0].length - 1] % 1000000007;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sumSubarrayMins(new int[]{3,1,2,4});
	}
}