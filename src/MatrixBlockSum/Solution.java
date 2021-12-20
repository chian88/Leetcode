package MatrixBlockSum;
import java.util.*;

class Solution {
	public int[][] matrixBlockSum(int[][] mat, int k) {
		int[][] dp = new int[mat.length][mat[0].length];
		int[][] res = new int[mat.length][mat[0].length];
		for (int i = 0;i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = mat[i][j];
				} else if (j != 0) {
					dp[i][j] = dp[i][j - 1] + mat[i][j];
				} else {
					dp[i][j] = dp[i - 1][dp[i - 1].length - 1] + mat[i][j];
				}

			}
		}

		for (int i = 0; i < dp.length; i ++) {
			for (int j = 0; j < dp[i].length; j++) {
				// lower riight
				int rowMax = Math.min(mat.length - 1,  i + k);
				int rowMin = Math.max(-1, i - k);
				int colMax = Math.min(mat[0].length - 1, j + k);
				int colMin = Math.max(-1, j - k);


				while (rowMax > rowMin) {
					res[i][j] += dp[rowMax][colMax];
					if (colMin < 0 && rowMax - 1 >= 0) {
						res[i][j] -= dp[rowMax - 1][dp[0].length - 1];
					} else if (colMin > 0) {
						res[i][j] -= dp[rowMax][colMin - 1];
					}
					rowMax -= 1;
				}


			}
		}

		return dp;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.matrixBlockSum(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, 1);
	}
}