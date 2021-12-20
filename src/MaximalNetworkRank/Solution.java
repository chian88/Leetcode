package MaximalNetworkRank;
import java.util.*;

class Solution {
	Map<Integer, Set<Integer>> graph = new HashMap<>();

	public int maximalNetworkRank(int n, int[][] roads) {
		for (int[] road : roads) {
			if (!graph.containsKey(road[0])) {
				graph.put(road[0], new HashSet<>());
			}

			if (!graph.containsKey(road[1])) {
				graph.put(road[1], new HashSet<>());
			}

			graph.get(road[0]).add(road[1]);
			graph.get(road[1]).add(road[0]);
		}
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int connectionFromA = 0;
				if (graph.get(i) != null) {
					connectionFromA = graph.get(i).size();
				}
				int connectionFromB = 0;
				if (graph.get(j) != null) {
					connectionFromB = graph.get(j).size();
				}
				int currRes = connectionFromA + connectionFromB;
				if (graph.get(i) != null && graph.get(i).contains(j)) {
					currRes -= 1;
				}

				res = Math.max(res, currRes);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maximalNetworkRank(4, new int[][]{{0,1}, {0,3}, {1,2}, {1,3}});
	}
}