package SortTheMatrixDiagonally;
import java.util.*;


class Solution {
	public int[][] diagonalSort(int[][] mat) {
		for (int row = mat.length - 1; row >= 0; row--) {
			int col = 0;
			List<Integer> diagonal = new ArrayList<>();
			int rowIter = row;
			while (rowIter < mat.length && col < mat[0].length) {
				diagonal.add(mat[rowIter][col]);
				rowIter++;
				col++;
			}

			Collections.sort(diagonal);

			rowIter = row;
			col = 0;
			int ptr = 0;
			while (rowIter < mat.length && col < mat[0].length) {
				mat[rowIter][col] = diagonal.get(ptr);
				rowIter++;
				col++;
				ptr++;
			}
		}

		for (int col = 1; col < mat[0].length; col++) {
			int row = 0;
			List<Integer> diagonal = new ArrayList<>();
			int colIter = col;

			while (row < mat.length && colIter < mat[0].length) {
				diagonal.add(mat[row][colIter]);
				row++;
				colIter++;
			}

			Collections.sort(diagonal);

			colIter = col;
			row = 0;
			int ptr = 0;
			while (row < mat.length && colIter < mat[0].length) {
				mat[row][colIter] = diagonal.get(ptr);
				colIter++;
				row++;
				ptr++;
			}
		}

		return mat;
	}
}