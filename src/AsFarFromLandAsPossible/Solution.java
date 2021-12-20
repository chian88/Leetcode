package AsFarFromLandAsPossible;
import java.util.*;


class Solution {
	public int maxDistance(int[][] grid) {
		int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		Queue<int[]> q = new LinkedList<>();
		boolean hasAtleastOneZero = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					q.add(new int[]{i, j});
				} else {
					hasAtleastOneZero = true;
				}
			}
		}

		if (q.isEmpty() || !hasAtleastOneZero) {
			return -1;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int level = 0;
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				int[] currOne = q.poll();
				for (int[] direction : directions) {
					int newRow = currOne[0] + direction[0];
					int newCol = currOne[1] + direction[1];

					if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
						continue;
					}

					if (visited[newRow][newCol] == false && grid[newRow][newCol] == 0) {
						visited[newRow][newCol] = true;
						q.add(new int[]{newRow, newCol});
					}
				}
				levelSize--;
			}

			level++;
		}

		return level - 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxDistance(new int[][]{{1,0,1}, {0,0,0}, {1,0,1}});
	}
}