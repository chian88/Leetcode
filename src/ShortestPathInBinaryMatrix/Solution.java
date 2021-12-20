package ShortestPathInBinaryMatrix;
import java.util.*;

class Pair {
	int row;
	int col;

	Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return row == pair.row && col == pair.col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
}

class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		boolean[][] dp = new boolean[grid.length][grid[0].length];


		Deque<int[]> q = new ArrayDeque<>();
		int dist = 1;

		if (grid[0][0] == 1) {
			return -1;
		}
		q.addLast(new int[]{0, 0});

		dp[0][0] = true;
		while (!q.isEmpty()) {
			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++){
				int[] curr = q.pollFirst();

				if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
					return dist;
				}


				List<int[]> neighbors = generateNeighbors(curr, grid, dp);

				for (int[] neighbor : neighbors) {
					if(neighbor[0] == grid.length - 1 && neighbor[1] == grid[0].length - 1) {
						return dist + 1;
					}
					dp[neighbor[0]][neighbor[1]] = true;
					q.addLast(neighbor);
				}
			}

			dist += 1;
		}
		return -1;
	}

	List<int[]> generateNeighbors (int[] curr, int[][] grid, boolean[][] dp) {
		int[][] directions = new int[][]{{-1,0}, {-1, 1}, {0, 1}, {1, 1}, {1,0}, {1, -1}, {0, -1}, {-1, -1}};
		List<int[]> res = new ArrayList<>();
		for (int[] direction : directions) {
			int[] next = new int[]{curr[0] + direction[0], curr[1] + direction[1]};

			if (next[0] < 0 || next[0] >= grid.length ) {
				continue;
			}

			if (next[1] < 0 || next[1] >= grid[0].length) {
				continue;
			}

			if (grid[next[0]][next[1]] == 0 && !dp[next[0]][next[1]]) {
				res.add(next);

			}
		}

		return res;
	}

	public static void main(String[] args) {

		Solution test = new Solution();
		test.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}});
	}
}