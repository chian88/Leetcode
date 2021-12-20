package SpiralMatrix2;
import java.util.*;

class Solution {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int nSquare = n * n;
		int counter = 1;

		int left = 0;
		int up = 0;
		int right = n - 1;
		int down = n - 1;
		while (counter <= nSquare) {

			for (int i = left; i <= right; i++) {
				res[up][i] = counter;
				counter++;
			}

			for (int i =  up + 1; i <= down; i++) {
				res[i][right] = counter;
				counter++;
			}

			if (up != down) {
				for (int i = right - 1; i >= left; i--) {
					res[down][i] = counter;
					counter++;
				}
			}

			if (left != right) {
				for (int i = down - 1; i > up; i--) {
					res[i][left] = counter;
					counter++;
				}
			}

			left++;
			up++;
			right--;
			down--;

		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.generateMatrix(4);
	}
}