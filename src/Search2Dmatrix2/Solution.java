package Search2Dmatrix2;
import java.util.*;


class Solution {
	private int[][] matrix;
	private int target;

	boolean searchRec(int left, int up, int right, int down) {
		if (left > right || up > down) {
			return false;
		} else if (target < matrix[up][left] || target > matrix[down][right]) {
			return false;
		}




		int mid = left + (right - left) / 2;

		int row = up;

		while (row <= down && matrix[row][mid] <= target) {
			if (matrix[row][mid] == target) {
				return true;
			}

			row++;
		}

		return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);

	}

	boolean searchMatrix(int[][] matrix, int target) {
		this.matrix = matrix;
		this.target = target;

		if (matrix == null || matrix.length == 0) {
			return false;
		}

		return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 5);
	}
}