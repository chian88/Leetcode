package LongestIncreasingPathInAMatrix;
import java.util.*;


class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 1);
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (dp[i][j] > 1) {
					continue;
				} else {
					int curr = dfs(matrix, dp, i, j, 1);
					res = Math.max(curr, res);
				}
			}
		}



		return res;
	}

	int dfs(int[][] matrix, int[][] dp, int i, int j, int depth) {
		dp[i][j] = Math.max(depth, dp[i][j]);

		int max = depth;
		// top
		if (i - 1 >= 0 && dp[i - 1][j] <= depth && matrix[i - 1][j] < matrix[i][j]) {
			max = Math.max(max, dfs(matrix, dp, i - 1, j, depth + 1));
		}

		// right
		if (j + 1 < matrix[0].length && dp[i][j + 1] <= depth && matrix[i][j + 1] < matrix[i][j]) {
			max = Math.max(max, dfs(matrix, dp, i, j + 1, depth + 1));
		}
		// down
		if (i + 1 < matrix.length && dp[i + 1][j] <= depth && matrix[i + 1][j] < matrix[i][j]) {
			max = Math.max(max, dfs(matrix, dp, i + 1, j, depth + 1));
		}

		//left
		if (j - 1 >= 0 && dp[i][j - 1] <= depth && matrix[i][j - 1] < matrix[i][j]) {
			max = Math.max(max, dfs(matrix, dp, i, j - 1, depth + 1));
		}

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}});
	}
}