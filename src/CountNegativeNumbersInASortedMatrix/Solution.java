package CountNegativeNumbersInASortedMatrix;
import java.util.*;

class Solution {
	public int countNegatives(int[][] grid) {
		int count = 0;

		int row = 0;
		int col = grid[0].length - 1;

		int colLen = grid[0].length;

		while (row < grid.length) {
			while(col >= 0 && grid[row][col] < 0) {
				col--;
			}
			count += colLen - (col + 1);
			row += 1;

		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countNegatives(new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}});
	}
}