package SearchA2DMatrix;
import java.util.*;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int top = 0;
		int bottom = matrix.length;

		int row = findRow(matrix, top, bottom, target);
		if (row >= matrix.length || row < 0) {
			return false;
		}
		return searchRow(matrix[row], 0, matrix[row].length, target);

	}

	boolean searchRow(int[] row, int left, int right, int target) {

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (target == row[mid]) {
				return true;
			} else if (target < row[mid]) {
				right = mid;
			} else if (target > row[mid]) {
				left = mid + 1;
			}
		}

		return false;
	}

	int findRow(int[][] matrix, int top, int bottom, int target) {

		while (top < bottom) {
			int mid = top + (bottom - top) / 2;
			int first = matrix[mid][0];
			int last = matrix[mid][matrix[mid].length - 1];

			if (target >= first && target <= last) {
				return mid;
			} else if (target < first) {
				bottom = mid;
			} else if (target > last) {
				top = mid + 1;
			}
		}

		return top;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20}, {23,30,34,60}};

		test.searchMatrix(matrix, 13);
	}
}