package CellsWithOddValuesInMatrix;
import java.util.*;

class Solution {
	public int oddCells(int m, int n, int[][] indices) {
		int[][] res = new int[m][n];
		for (int[] index : indices) {
			int row = index[0];
			int col = index[1];

			for (int j = 0; j < n; j++) {
				res[row][j] += 1;
			}

			for (int i = 0; i < m; i++){
				res[i][col] += 1;
			}
		}
		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (res[i][j] % 2 == 1) {
					result += 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.oddCells(2,3, new int[][]{{0,1},{1,1}});
	}
}