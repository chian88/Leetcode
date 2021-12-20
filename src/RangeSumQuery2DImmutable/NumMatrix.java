package RangeSumQuery2DImmutable;
import java.util.*;


class NumMatrix {
	int[][] prefixSum;
	public NumMatrix(int[][] matrix) {
		int[][] prefixSum = new int[matrix.length][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			int runningSum = 0;
			prefixSum[i][0] = runningSum;
			for (int j = 1; j <= matrix[i].length; j++) {
				runningSum += matrix[i][j - 1];
				prefixSum[i][j] = runningSum;
			}
		}

		this.prefixSum = prefixSum;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int ans = 0;
		for (int i = row1; i <= row2; i++) {
			ans += (prefixSum[i][col2 + 1] - prefixSum[i][col1]);
		}

		return ans;
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */