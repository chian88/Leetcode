package Rotate;
import java.util.*;


class Solution {
	public static void rotate(int[][] matrix) {
		int n = matrix.length - 1;
		for (int offset = 0; offset < (n+1) / 2; offset++) {
			for (int i = offset; i < n - offset; i++) {
				int temp1 = matrix[i][n-offset];
				int temp2 = matrix[n -offset][n-i];
				int temp3 = matrix[n-i][offset];
				int temp4 = matrix[offset][i];

				matrix[i][n-offset] = temp4;
				matrix[n -offset][n-i] = temp1;
				matrix[n-i][offset] = temp2;
				matrix[offset][i] = temp3;

			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = {{5,1,9,11},
				{2,4,8,10},
				{13,3,6,7},
				{15,14,12,16}};

		rotate(matrix);
	}
}