package ShortestPathInAGridWithObstaclesElimination;
import java.util.*;

class Cell {
	int row;
	int col;
	int k;
	int step;

	Cell(int row, int col, int k, int step) {
		this.row = row;
		this.col = col;
		this.k = k;
		this.step = step;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cell cell = (Cell) o;
		return row == cell.row && col == cell.col && k == cell.k;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col, k);
	}
}

class Solution {
	public int shortestPath(int[][] grid, int k) {


		int m = grid.length, n = grid[0].length;
		if (m == 1 && n == 1) {
			if (grid[0][0] == 1) {
				return -1;
			}
			return 0;
		}


		HashSet<Cell> seen = new HashSet<>();
		Queue<Cell> q = new LinkedList<>();
		Cell first = new Cell(0, 0, k, 0);
		seen.add(first);
		q.add(first);
		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while (!q.isEmpty()) {

			Cell curr = q.poll();

			for (int[] dir : dirs) {
				int newRow = curr.row + dir[0];
				int newCol = curr.col + dir[1];

				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n ) {
					if (grid[newRow][newCol] == 0) {
						if (newRow == m - 1 && newCol == n - 1) {
							return curr.step + 1;
						}
						Cell toVisit = new Cell(newRow, newCol, curr.k, curr.step + 1);
						if (!seen.contains(toVisit)) {
							seen.add(toVisit);
							q.add(toVisit);
						}

					} else if (curr.k > 0 && grid[newRow][newCol] == 1) {
						if (newRow == m - 1 && newCol == n - 1) {
							return curr.step + 1;
						}
						Cell toVisit = new Cell(newRow, newCol, curr.k - 1, curr.step + 1);
						if (!seen.contains(toVisit)) {
							seen.add(toVisit);
							q.add(toVisit);
						}
					}
				}
			}

		}

		return -1;
	}


}

