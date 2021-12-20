package SpiralMatrix;
import java.util.*;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int up = 0;
		int down  = m - 1;
		int left = 0;
		int right = n - 1;

		List<Integer> res = new ArrayList<>();

		while (res.size() < m * n) {
			for (int col = left; col <= right; col++) {
				res.add(matrix[up][col]);
			}

			for (int row = up + 1; row <= down; row++) {
				res.add(matrix[row][right]);
			}

			if (up != down) {
				for (int col = right - 1; col >= left; col--) {
					res.add(matrix[down][col]);
				}
			}

			if (left != right) {
				for (int row = down - 1; row > up; row--) {
					res.add(matrix[row][left]);
				}
			}

			up++;
			down--;
			left++;
			right--;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
	}
}






//class Solution {
//	public List<Integer> spiralOrder(int[][] matrix) {
//		List<Integer> res = new ArrayList<>();
//		int rows = matrix.length;
//		int columns = matrix[0].length;
//		int up = 0;
//		int left = 0;
//		int right = columns - 1;
//		int down = rows - 1;
//
//		while (res.size() < rows * columns) {
//			for (int col = left;  col <= right; col++) {
//				res.add(matrix[up][col]);
//			}
//
//			for (int row = up + 1; row <= down; row++) {
//				res.add(matrix[row][right]);
//			}
//
//			if (up != down) {
//				for (int col = right - 1; col >= left; col--) {
//					res.add(matrix[down][col]);
//				}
//			}
//
//			if (left != right) {
//				for (int row = down - 1; row > up; row--) {
//					res.add(matrix[row][left]);
//				}
//			}
//
//			left++;
//			right--;
//			up++;
//			down--;
//		}
//
//		return res;
//	}
//
//	public static void main(String[] args) {
////		int[][] matrix = new int[][] {{1,2,3,4,5,6,7},
////									{8,9,10,11,12,13,14},
////									{15,16,17,18,19,20,21},
////									{22,23,24,25,26,27, 28},
////									{29,30,31,32,33,34,35},
////									{36,37,38,39,40,41,42},
////									{43,44,45,46,47,48,49}};
////		int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//
////		int[][] matrix = new int[][]{{7}, {9}, {6}};
//		int[][] matrix = new int[][] {{2,5,8}, {4,0,-1}};
//		Solution test = new Solution();
//		test.spiralOrder(matrix);
//	}
//}