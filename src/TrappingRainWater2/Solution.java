package TrappingRainWater2;
import java.util.*;

class Cell {
	int row;
	int col;
	int height;

	Cell(int row, int col, int height) {
		this.row = row;
		this.col = col;
		this.height = height;
	}
}

class Solution {
	public int trapRainWater(int[][] heightMap) {
		PriorityQueue<Cell> heap = new PriorityQueue<>( new Comparator<Cell>() {
			public int compare(Cell a, Cell b) {
				return a.height - b.height;
			}
		});

		int m = heightMap.length;
		int n = heightMap[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			heap.offer(new Cell(i, 0, heightMap[i][0]));
			heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}

		for (int j = 0; j < n; j++) {
			visited[0][j] = true;
			visited[m - 1][j] = true;
			heap.offer(new Cell(0, j, heightMap[0][j]));
			heap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
		}

		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int res = 0;

		while (!heap.isEmpty()) {
			Cell curr = heap.poll();

			for (int[] dir : dirs) {
				int newRow = curr.row + dir[0];
				int newCol = curr.col + dir[1];

				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
					visited[newRow][newCol] = true;
					res += Math.max(0, curr.height - heightMap[newRow][newCol]);
					heap.offer(new Cell(newRow, newCol, Math.max(heightMap[newRow][newCol], curr.height)));
				}
			}
		}
		return res;
	}
}