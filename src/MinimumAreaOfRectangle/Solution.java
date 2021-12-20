package MinimumAreaOfRectangle;
import java.util.*;

class Edge {
	int y1;
	int y2;

	Edge(int y1, int y2) {
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		return y1 == edge.y1 && y2 == edge.y2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(y1, y2);
	}
}

class Solution {
	public int minAreaRect(int[][] points) {
		Map<Integer, List<Integer>> xToYs = new LinkedHashMap<>();

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];

			xToYs.putIfAbsent(point[0], new ArrayList<>());
			xToYs.get(point[0]).add(point[1]);
		}

		Map<Edge, Integer> edgeToX = new LinkedHashMap<>();

		long minArea = Long.MAX_VALUE;

		for (Map.Entry<Integer, List<Integer>> column : xToYs.entrySet()) {
			int col = column.getKey();

			List<Integer> rows = column.getValue();

			Collections.sort(rows);

			for (int i = 1; i < rows.size(); i++) {
				for (int j = 0; j < i; j++) {
					Edge e = new Edge(rows.get(j),  rows.get(i));

					if (edgeToX.containsKey(e)) {
						int height = Math.abs(rows.get(j) - rows.get(i));
						int width = Math.abs(col - edgeToX.get(e));
						long currArea = height * width;

						minArea = Math.min(minArea, currArea);
					}

					edgeToX.put(e, col);
				}


			}
		}

		return minArea == Long.MAX_VALUE ? 0 : (int) minArea % 1000000007;
	}

	public static void main(String[] args) {
		Solution test = new Solution();

		test.minAreaRect(new int[][]{{36219,4673},{26311,36047},{26311,4673},{36219,16024},{17010,16024},{26311,6287},{22367,6287},{17010,36047},{17010,6287},{22367,16024},{36219,6287},{22367,4673},{17010,4673},{36219,36047}});
	}
}