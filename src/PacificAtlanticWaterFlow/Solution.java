package PacificAtlanticWaterFlow;
import java.util.*;

class Solution {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		boolean[][] dp = new boolean[heights.length][heights[0].length];

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				Deque<int[]> q = new ArrayDeque<>();

				q.addLast(new int[]{i, j});
				boolean reachPacific = false;
				boolean reachAtlantic = false;

				boolean[][] visited = new boolean[heights.length][heights[0].length];
				visited[i][j] = true;
				while (!q.isEmpty()) {
					int[] curr = q.pollFirst();

					if (dp[curr[0]][curr[1]] == true) {
						reachAtlantic = true;
						reachPacific = true;
						break;
					}
					// top
					if (curr[0] - 1 < 0) {
						reachPacific = true;
					} else if (heights[curr[0] - 1][curr[1]] <= heights[curr[0]][curr[1]] && !visited[curr[0] - 1][curr[1]]) {
						visited[curr[0] - 1][curr[1]] = true;
						q.addLast(new int[]{curr[0] - 1, curr[1]});
					}
					// left
					if (curr[1] - 1 < 0) {
						reachPacific = true;
					} else if (heights[curr[0]][curr[1] - 1] <= heights[curr[0]][curr[1]] && !visited[curr[0]][curr[1] - 1]) {
						visited[curr[0]][curr[1] - 1] = true;
						q.addLast(new int[]{curr[0], curr[1] - 1});
					}
					// right
					if (curr[1] + 1 == heights[0].length) {
						reachAtlantic = true;
					} else if (heights[curr[0]][curr[1] + 1] <= heights[curr[0]][curr[1]] && !visited[curr[0]][curr[1] + 1]) {
						visited[curr[0]][curr[1] + 1] = true;
						q.addLast(new int[]{curr[0], curr[1] + 1});
					}

					// down;
					if (curr[0] + 1 == heights.length) {
						reachAtlantic = true;
					} else if (heights[curr[0] + 1][curr[1]] <= heights[curr[0]][curr[1]] && !visited[curr[0] + 1][curr[1]]) {
						visited[curr[0] + 1][curr[1]] = true;
						q.addLast(new int[]{curr[0] + 1, curr[1]});
					}

					if (reachAtlantic && reachPacific) {
						break;
					}
				}

				if (reachAtlantic && reachPacific) {
					dp[i][j] = true;
					res.add(Arrays.asList(i, j));
				}
			}
		}

		return res;
	}
}