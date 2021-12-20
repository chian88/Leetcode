package MinimumCostTreeFromLeafValues;
import java.util.*;

class Solution {
	public int mctFromLeafValues(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];

		for (int[] arrray : dp) {
			Arrays.fill(arrray, Integer.MAX_VALUE);
		}

		int i = 0;
		int j = 0;
		int offset = 0;

		while (j != arr.length) {
			if (i == j) {
				dp[i][j] = 0;
			} else {
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], max(arr, i,k) * max(arr, k + 1, j) + dp[i][k] + dp[k + 1][j] );
				}
			}


			if (j == arr.length - 1) {
				offset += 1;
				i = 0 ;
				j = offset;
			} else {
				i += 1;
				j += 1;
			}



		}

		return dp[0][dp.length - 1];
 	}

	 int max(int[] arr, int i, int j) {
		int max = arr[i];
		for (int z = i; z <= j; z++) {
			max = Math.max(max, arr[z]);
		}

		return max;
	 }

	public static void main(String[] args) {
		Solution test = new Solution();
		test.mctFromLeafValues(new int[]{5,7,3,5});
	}
}