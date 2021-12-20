package DetermineWhetherMatrixCanBeObtainedByRotation;
import java.util.*;

class Solution {
	public boolean findRotation(int[][] mat, int[][] target) {
		int n = mat.length;
		int[][] right = new int[n][n];
		int[][] down = new int[n][n];
		int[][] left = new int[n][n];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				right[col][n - row - 1] = mat[row][col];
				down[n - row - 1][n - col - 1] = mat[row][col];
				left[n - col - 1][row] = mat[row][col];
			}
		}

		boolean allMatchTop = true;
		boolean allMatchRight = true;
		boolean allMatchDown = true;
		boolean allMatchLeft = true;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (mat[row][col] != target[row][col]) {
					allMatchTop = false;
				}

				if (right[row][col] != target[row][col]) {
					allMatchRight = false;
				}

				if (down[row][col] != target[row][col]) {
					allMatchDown = false;
				}

				if (left[row][col] != target[row][col]) {
					allMatchLeft = false;
				}
			}
		}


		return allMatchTop || allMatchDown || allMatchLeft || allMatchRight;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findRotation(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
	}
}