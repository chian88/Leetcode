package DiagonalTraverse;
import java.util.*;


class Solution {
	public int[] findDiagonalOrder(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		boolean tiktok = true;
		int row = 0;
		int col = 0;
		int[] res = new int[m * n];

		int ptr = 0;
		while (row < m && col < n) {
			res[ptr] = mat[row][col];
			ptr++;
			if (tiktok) {
				row--;
				col++;
				if (row == -1 && col == n) {
					row = 1;
					col = n - 1;
					tiktok = !tiktok;
				} else if (row == -1) {
					row = 0;
					tiktok = !tiktok;
				} else if (col == n) {
					col = n -1;
					row += 2;
					tiktok = !tiktok;
				}
			} else {
				row++;
				col--;
				if (row == m && col == -1) {
					row = m - 1;
					col = 1;
					tiktok = !tiktok;
				} else if (col == -1) {
					col = 0;
					tiktok = !tiktok;
				} else if (row == m) {
					row = m - 1;
					col += 2;
					tiktok = !tiktok;
				}
			}


		}
		return res;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
	}
}



























//class Solution {
//	public int[] findDiagonalOrder(int[][] mat) {
//		int[] res = new int[mat.length * mat[0].length];
//
//		int ptr = 0;
//		int row = 0;
//		int col = 0;
//		boolean leftToRight = true;
//		while (row < mat.length && col < mat[0].length) {
//			if (leftToRight) {
//				while (row > 0 && col < mat[0].length - 1) {
//					res[ptr] = mat[row][col];
//					ptr++;
//					row--;
//					col++;
//				}
//
//				res[ptr] = mat[row][col];
//				ptr++;
//
//				if (row == 0 && col == mat[0].length - 1) {
//					row += 1;
//				} else if (row == 0) {
//					col += 1;
//				} else if (col == mat[0].length - 1) {
//					row += 1;
//				}
//
//
//				leftToRight = !leftToRight;
//			} else {
//				while (row < mat.length - 1 && col > 0) {
//					res[ptr] = mat[row][col];
//					ptr++;
//					row++;
//					col--;
//				}
//
//				res[ptr] = mat[row][col];
//				ptr++;
//
//				if (row == mat.length - 1 && col == 0) {
//					col += 1;
//				} else if (row == mat.length - 1) {
//					col += 1;
//				} else if (col == 0) {
//					row += 1;
//				}
//
//				leftToRight = !leftToRight;
//			}
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
//	}
//}