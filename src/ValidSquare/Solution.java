package ValidSquare;
import java.util.*;


class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<int[]> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);

		Collections.sort(points, (o1, o2) -> {
			int xCmp = Integer.compare(o1[0], o2[0]);

			if (xCmp != 0) {
				return xCmp;
			}

			return Integer.compare(o1[1], o2[1]);
		});

		int[] point1 = points.get(0);
		int[] point2 = points.get(1);
		int[] point3 = points.get(2);
		int[] point4 = points.get(3);

		if (point1[0] != point2[0]) {
			return false;
		}

		if (point3[0] != point4[0]) {
			return false;
		}

		if (point1[1] != point3[1]) {
			return false;
		}

		if (point2[1] != point4[1]) {
			return false;
		}

		int horizontal = point3[0] - point1[0];

		if (horizontal == 0) {
			return false;
		}

		int vertical = point2[1] - point1[1];

		if (vertical == 0) {
			return false;
		}

		if (horizontal != (point4[0] - point2[0])) {
			return false;
		}

		if (vertical != (point4[1] - point3[1])) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.validSquare(new int[]{1,0}, new int[]{-1,0}, new int[]{0, 1}, new int[]{0, -1});
	}
}