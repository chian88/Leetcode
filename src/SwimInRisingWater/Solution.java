package SwimInRisingWater;
import java.util.*;

class Square {
	int i;
	int j;
	int elevation;

	Square(int i , int j , int elevation) {
		this.i = i;
		this.j = j;
		this.elevation = elevation;
	}
}

class Solution {
	public int swimInWater(int[][] grid) {
		if (grid.length == 1) {
			return 0;
		}

		PriorityQueue<Square> heap = new PriorityQueue<>(new Comparator<Square>() {
			public int compare(Square s1, Square s2) {
				return s1.elevation - s2.elevation;
			}
		});

		heap.add(new Square(0, 1, grid[0][1]));
		heap.add(new Square(1, 0, grid[1][0]));
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[0][0] = true;
		int t = grid[0][0];
		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while (true) {
			while (heap.peek().elevation <= t) {
				Square curr = heap.poll();

				if (curr.i == grid.length - 1 && curr.j == grid[0].length - 1) {
					return t;
				}

				for (int[] dir : dirs) {
					int newRow = curr.i + dir[0];
					int newCol = curr.j + dir[1];

					if (newRow >= 0 && newRow < grid.length
							&& newCol < grid[0].length && newCol >= 0
							&& !visited[newRow][newCol]) {
						visited[newRow][newCol] = true;
						heap.add(new Square(newRow, newCol, grid[newRow][newCol]));
					}
				}

			}

			t++;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.swimInWater(new int[][]{{3,2}, {0,1}});
//		test.swimInWater(new int[][]{{0,1,2,3,4},
//									{24,23,22,21,5},
//									{12,13,14,15,16},
//									{11,17,18,19,20},
//									{10,9,8,7,6}});
	}
}