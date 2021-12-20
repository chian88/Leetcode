package WallsAndGates;
import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

class Solution {
	public void wallsAndGates(int[][] rooms) {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					q.add(new Point(i, j));
				}
			}
		}

		int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		int dist = 0;
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				Point curr = q.poll();

				for (int[] dir : directions) {
					int newRow = curr.x + dir[0];
					int newCol = curr.y + dir[1];
					Point newPoint = new Point(newRow, newCol);
					if (newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length
							&& rooms[newRow][newCol] == Integer.MAX_VALUE) {
						rooms[newRow][newCol] = dist + 1;
						q.add(newPoint);
					}
				}

				levelSize--;
			}

			dist++;
		}
	}
}















//class Solution {
//	public void wallsAndGates(int[][] rooms) {
//		int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//		Queue<int[]> q = new LinkedList<>();
//
//		for (int i = 0; i < rooms.length; i++) {
//			for (int j = 0; j < rooms[i].length; j++) {
//				if (rooms[i][j] == 0) {
//					q.add(new int[]{i, j});
//				}
//			}
//		}
//
//
//		int dist = 1;
//		while (!q.isEmpty()) {
//			int levelSize = q.size();
//
//			while (levelSize > 0) {
//				int[] curr = q.poll();
//
//				for (int[] direction : directions) {
//					int newRow = curr[0] + direction[0];
//					int newCol = curr[1] + direction[1];
//
//					if (newRow < 0 || newRow >= rooms.length || newCol < 0 || newCol >= rooms[0].length) {
//						continue;
//					}
//
//					if (rooms[newRow][newCol] == Integer.MAX_VALUE) {
//						rooms[newRow][newCol] = dist;
//						q.add(new int[]{newRow, newCol});
//					}
//				}
//
//
//				levelSize--;
//			}
//
//			dist++;
//		}
//	}
//}