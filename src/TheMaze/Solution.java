package TheMaze;
import java.util.*;

class Point {
	int row;
	int col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return row == point.row && col == point.col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
}
class Solution {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		Deque<Point> q = new ArrayDeque<>();
		Set<Point> visited = new HashSet<>();
		Point startP = new Point(start[0], start[1]);
		q.addFirst(startP);
		visited.add(startP);
		while (!q.isEmpty()) {
			Point curr = q.pollLast();

			List<Point> nextPoints = findNextPoint(curr, maze);

			for (Point nextPoint : nextPoints) {
				if (nextPoint.row == destination[0] && nextPoint.col == destination[1]) {
					return true;
				}
				if (!visited.contains(nextPoint)) {
					visited.add(nextPoint);
					q.addFirst(nextPoint);
				}
			}
		}

		return false;
	}

	List<Point> findNextPoint(Point curr, int[][] maze) {
		// top
		List<Point> res = new ArrayList<>();

		Point up = new Point(curr.row, curr.col);
		while (up.row - 1 >= 0 && maze[up.row - 1][up.col] == 0 ) {
			up.row = up.row - 1;
		}

		Point right = new Point(curr.row, curr.col);
		while (right.col + 1 < maze[0].length && maze[right.row][right.col + 1] == 0 ) {
			right.col = right.col + 1;
		}

		Point down = new Point(curr.row, curr.col);
		while (down.row + 1 < maze.length && maze[down.row + 1][down.col] == 0 ) {
			down.row = down.row + 1;
		}

		Point left = new Point(curr.row, curr.col);
		while (left.col - 1 >= 0 && maze[left.row][left.col - 1] == 0 ) {
			left.col = left.col - 1;
		}

		res.add(up);
		res.add(right);
		res.add(down);
		res.add(left);

		return res;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[][] maze = new int[][]{{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
		int[] start = new int[]{0,4};
		int[] end = new int[]{3,2};
		test.hasPath(maze, start, end);
	}
}