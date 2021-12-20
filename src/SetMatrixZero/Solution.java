package SetMatrixZero;
import java.util.*;




class Solution {
	public void setZeroes(int[][] matrix) {
		HashSet<Integer> rowLocation = new HashSet<>();
		HashSet<Integer> colLocation = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowLocation.add(i);
					colLocation.add(j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowLocation.contains(i)) {
					matrix[i][j] = 0;
				}

				if (colLocation.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}