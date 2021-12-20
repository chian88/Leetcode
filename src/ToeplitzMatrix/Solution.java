package ToeplitzMatrix;
import java.util.*;
class Solution {
	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			int newRow = row;
			int newCol = 0;
			int originalVal = matrix[newRow][newCol];
			while (newRow < matrix.length && newCol < matrix[0].length) {
				if (matrix[newRow][newCol] != originalVal) {
					return false;
				}

				newRow++;
				newCol++;
			}
		}

		for (int col = 0; col < matrix[0].length; col++) {
			int newRow = 0;
			int newCol = col;
			int originalVal = matrix[newRow][newCol];
			while (newRow < matrix.length && newCol < matrix[0].length) {
				if (matrix[newRow][newCol] != originalVal) {
					return false;
				}

				newRow++;
				newCol++;
			}
		}

		return true;
	}
}