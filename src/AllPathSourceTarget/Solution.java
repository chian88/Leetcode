package AllPathSourceTarget;
import java.util.*;


class Solution {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();

		allPathSourceTargetHelper(graph, 0, res, new ArrayList<>());
		return res;
	}

	void allPathSourceTargetHelper(int[][] graph, int curr, List<List<Integer>> res, List<Integer> intermediateRes) {
		intermediateRes.add(curr);
		if (curr == graph.length - 1) {
			res.add(new ArrayList<>(intermediateRes));
			intermediateRes.remove(intermediateRes.size() - 1);

			return;
		}


		int[] nextNodes = graph[curr];

		for(int i = 0; i < nextNodes.length; i++) {
			allPathSourceTargetHelper(graph, nextNodes[i], res, intermediateRes);
		}

		intermediateRes.remove(intermediateRes.size() - 1);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
	}
}