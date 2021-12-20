package MaximumLengthOfPairChain;
import java.util.*;

class Solution {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (o1, o2) -> {
			int cmp = Integer.compare(o1[0], o2[0]);
			if (cmp != 0) {
				return cmp;
			}
			return Integer.compare(o1[1], o2[1]);
		});
		int[] dp = new int[pairs.length];
		return recursion(pairs, 0, dp);
	}


	int recursion(int[][] pairs, int idx, int[] dp) {
		if (idx >= pairs.length) {
			return 0;
		}
		if (dp[idx] > 0) {
			return dp[idx];
		}
		int max  = 1;

		for (int i = idx + 1; i < pairs.length; i++) {

			if (pairs[idx][1] < pairs[i][0]) {
				max = Math.max(max, recursion(pairs, i, dp) + 1);
			} else {
				max = Math.max(max, recursion(pairs, i, dp));
			}

		}
		dp[idx] = max;
		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findLongestChain(new int[][]{{1,3}, {3,5}, {4,7}, {7,8}, {9, 10}});
	}
}