package IslandPerimeter;
import java.util.*;


class Solution {
	public int islandPerimeter(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					return dfs(i, j, grid, visited);
				}
			}
		}

		return 0;
	}

	int dfs(int i, int j, int[][] grid, boolean[][] visited) {
		int perimeter = 0;
		visited[i][j] = true;
		// top
		if (i - 1 >= 0 && grid[i - 1][j] == 1) {

			if (!visited[i - 1][j]) {
				perimeter += dfs(i-1, j, grid, visited);
			}
		} else {
			perimeter += 1;
		}

		// right
		if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
			if (!visited[i][j + 1]) {
				perimeter += dfs(i, j + 1, grid, visited);
			}
		} else {
			perimeter += 1;
		}

		// down
		if (i + 1 < grid.length && grid[i + 1][j] == 1) {
			if (!visited[i + 1][j]) {
				perimeter += dfs(i + 1, j, grid, visited);
			}
		} else {
			perimeter += 1;
		}

		// left

		if (j - 1 >= 0 && grid[i][j - 1] == 1) {
			if (!visited[i][j - 1]) {
				perimeter += dfs(i, j - 1, grid, visited);
			}
		} else {
			perimeter += 1;
		}

		return perimeter;
	}
}