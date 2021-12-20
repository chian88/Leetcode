package Largest1BorderedSquare;
import java.util.*;

class Solution {
	public int largest1BorderedSquare(int[][] grid) {
		int[][][] dp = new int[grid.length][grid[0].length][2];
		int res = 0;
		for(int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				int top = 0;
				if (i + 1 < grid.length) {
					top = dp[i + 1][j][0];
				}

				int right = 0;
				if (j + 1 < grid[0].length) {
					right = dp[i][j + 1][1];
				}

				if (grid[i][j] == 1) {
					dp[i][j][0] = top + 1;
					dp[i][j][1] = right + 1;
				}
			}
		}

		for (int i = 0; i < grid.length; i ++) {
			for (int j = 0; j < grid[0].length; j++) {
				int sides = Math.min(dp[i][j][0], dp[i][j][1]);

				for (int side = sides; side >= 1; side--) {
					int rightCellDown = dp[i][j + side - 1][0];
					int downCellRight = dp[i + side - 1][j][1];
					if (side <= rightCellDown && side <= downCellRight) {
						res = Math.max(res, side * side);
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.largest1BorderedSquare(new int[][]{{1,1,0,0}});
	}
}