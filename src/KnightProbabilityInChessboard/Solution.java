package KnightProbabilityInChessboard;
import java.util.*;

class Solution {
	public double knightProbability(int n, int k, int row, int column) {
		double[][] dp = new double[n][n];

		int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
		int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

		dp[row][column] = 1;

		for (; k > 0; k--) {
			double[][] dp2 = new double[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					for (int q = 0; q < 8; q++) {
						int cr = r + dr[q];
						int cc = c + dc[q];

						if (cr >= 0 && cr < n && cc >= 0 && cc < n) {
							dp2[cr][cc] += dp[r][c] / 8.0;
						}
					}
				}
			}

			dp = dp2;
		}


		double ans = 0.0;
		for (double[] r : dp) {
			for (double x : r) {
				ans += x;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.knightProbability(5, 2, 0, 0);
	}
}