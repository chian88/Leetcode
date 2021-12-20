package CountSquareSubmatricesWithAllOnes;
import java.util.*;

class Solution {
	public int countSquares(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		int sum = 0;
		for (int i = 0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j];
				} else {
					if (matrix[i][j] == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
					}
				}
				sum += dp[i][j];
			}
		}
		return sum;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countSquares(new int[][]{{0,1,1,1}, {1,1,1,1}, {0,1,1,1}});
	}
}