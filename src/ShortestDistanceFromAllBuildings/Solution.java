package ShortestDistanceFromAllBuildings;
import java.util.*;


class Solution {
	public int shortestDistance(int[][] grid) {
		int[][] distance = new int[grid.length][grid[0].length];
		int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		HashSet<Integer>[][] visited = new HashSet[grid.length][grid[0].length];

		Queue<int[]> q = new LinkedList<>();
		int id = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				visited[i][j] = new HashSet<>();
				if (grid[i][j] == 1) {
					q.add(new int[]{i, j, id});
					id++;
				}
			}
		}

		int numberOfBuildings = q.size();

		int dist = 1;
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				int[] curr = q.poll();
				for (int[] direction : directions) {
					int newRow = curr[0] + direction[0];
					int newCol = curr[1] + direction[1];

					if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
						continue;
					}

					if (grid[newRow][newCol] == 0 && !visited[newRow][newCol].contains(curr[2])) {
						distance[newRow][newCol] += dist;

						visited[newRow][newCol].add(curr[2]);
						q.add(new int[]{newRow, newCol, curr[2]});
					}
				}

				levelSize--;
			}

			dist++;
		}

		int res = Integer.MAX_VALUE;
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0;  j < grid[i].length;j++) {
				if (grid[i][j] == 0 && visited[i][j].size() == numberOfBuildings) {
					res = Math.min(res, distance[i][j]);
				}
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.shortestDistance(new int[][]{{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}});
	}
}