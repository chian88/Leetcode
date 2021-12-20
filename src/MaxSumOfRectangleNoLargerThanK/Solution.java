package MaxSumOfRectangleNoLargerThanK;
import java.util.*;

public class Solution {
	int result = Integer.MIN_VALUE;

	void updateResult(int[] nums, int k) {
		int sum = 0;
		TreeSet<Integer> sortedSum = new TreeSet<>();
		sortedSum.add(0);
		for (int num : nums) {
			sum += num;
			Integer x = sortedSum.ceiling(sum - k);

			if (x != null) {
				result = Math.max(result, sum - x);
			}

			sortedSum.add(sum);
		}
	}


	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix[0].length > matrix.length) {
			int[] rowSum = new int[matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				Arrays.fill(rowSum, 0);

				for (int row = i; row < matrix.length; row++) {
					for (int col = 0; col < matrix[0].length; col++) {
						rowSum[col] += matrix[row][col];
					}

					updateResult(rowSum, k);

					if (result == k) {
						return result;
					}
				}
			}
		} else {
			int[] colSum = new int[matrix.length];
			for (int i = 0; i < matrix[0].length; i++) {
				Arrays.fill(colSum, 0);

				for (int col = i; col < matrix[0].length; col++) {
					for (int row = 0; row < matrix.length; row++) {
						colSum[row] += matrix[row][col];
					}

					updateResult(colSum, k);

					if (result == k) {
						return result;
					}
				}
			}
		}

		return result;
	}

}
