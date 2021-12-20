package RestoreArrayFromAdjacentPairs;
import java.util.*;

class Solution {
	public int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] pair : adjacentPairs) {
			graph.putIfAbsent(pair[0], new ArrayList<>());
			graph.putIfAbsent(pair[1], new ArrayList<>());

			graph.get(pair[0]).add(pair[1]);
			graph.get(pair[1]).add(pair[0]);
		}
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if (entry.getValue().size() == 1) {
				List<Integer> res = new ArrayList<>();
				dfs(entry.getKey(), graph, res, new HashSet<>());
				int[] result = new int[res.size()];
				for (int i = 0; i < res.size(); i++) {
					result[i] = res.get(i);
				}
				return result;
			}
		}
		return null;
 	}

	 void dfs(int vertex, Map<Integer, List<Integer>> graph, List<Integer> res, Set<Integer> visited) {
		visited.add(vertex);
		res.add(vertex);

		List<Integer> nexts = graph.get(vertex);

		if (nexts == null) {
			return;
		}

		for (int next : nexts) {
			if (!visited.contains(next)) {
				dfs(next, graph, res, visited);
			}
		}
	 }

	public static void main(String[] args) {
		Solution test = new Solution();
		test.restoreArray(new int[][]{{2,1}, {3,4}, {3,2}});
	}
}