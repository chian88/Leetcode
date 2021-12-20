package ScoreAfterFlippingMatrix;
import java.util.*;

class Solution {
	public int matrixScore(int[][] grid) {
		// turn row;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == 0) {
				for (int j = 0; j < grid[i].length; j++) {
					grid[i][j] = 1-grid[i][j];
				}
			}
		}

		for (int j = 0; j < grid[0].length; j++) {
			int countOfZeros = 0;
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 0) {
					countOfZeros++;
				}
			}

			if (countOfZeros > grid.length / 2) {

				for (int i = 0; i < grid.length; i++) {
					grid[i][j] = 1 - grid[i][j];
				}
			}
		}

		int pow = 0;
		int sum = 0;
		for (int j = grid[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					sum += Math.pow(2, pow);
				}
			}
			pow++;
		}

		return sum;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.matrixScore(new int[][]{{0,0,1,1}, {1,0,1,0}, {1,1,0,0}});
	}
}