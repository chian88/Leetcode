package maxAreaOfIsland;
import java.util.*;

class Solution {
	public static int maxAreaOfIsland(int[][] grid) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int count = depthFirstSearch(grid,  i, j);
					if (count > max) max = count;

				}
			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

	private static int depthFirstSearch(int[][] grid, int i , int j) {
		// left
		grid[i][j] = -1;
		int count = 0;
		if (j-1 >= 0 && grid[i][j-1] == 1) {
			count += depthFirstSearch(grid, i, j-1);
		}

		// top
		if (i-1 >= 0 && grid[i-1][j] == 1) {
			count += depthFirstSearch(grid, i-1, j);
		}

		// right
		if (j+1 < grid[0].length && grid[i][j+1] == 1) {
			count += depthFirstSearch(grid, i, j+1);
		}
		// down

		if (i+1 < grid.length && grid[i+1][j] == 1) {
			count += depthFirstSearch(grid, i+1, j);
		}

		return count + 1;
	}

	public static void main(String[] args) {
		int[][] array = new int[][] { {0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(maxAreaOfIsland(array));
	}
}