package ReachingPoints;
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
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		HashSet<Point> seen = new HashSet<>();
		recursion(new Point(sx, sy), seen, tx, ty);

		return seen.contains(new Point(tx, ty));
	}

	void recursion(Point curr, Set<Point> seen, int tx, int ty) {
		if (curr.x > tx || curr.y > ty) {
			return;
		}

		seen.add(curr);

		recursion(new Point(curr.x + curr.y, curr.y), seen, tx, ty);
		recursion(new Point(curr.x, curr.x + curr.y), seen, tx, ty);
	}
}











