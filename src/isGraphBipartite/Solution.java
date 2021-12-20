package isGraphBipartite;
import java.util.*;

class Solution {
	public boolean isBipartite(int[][] graph) {
		int[] uf = new int[graph.length];
		Arrays.fill(uf, -1);

		for (int i = 0; i < graph.length; i++) {
			if (uf[i] == -1) {
				// only dfs when this is unmarked.
				Deque<Integer> stack = new ArrayDeque<>();
				uf[i] = 0;
				stack.addFirst(i);

				while (!stack.isEmpty()) {
					int curr = stack.pollFirst();
					int[] neighbors = graph[curr];

					for (int neighbor : neighbors) {
						if (uf[neighbor] == -1) {
							uf[neighbor] = uf[curr] == 1 ? 0 : 1;
							stack.addFirst(neighbor);
						} else if (uf[neighbor] == uf[curr]) {
							return false;
						}
					}
				}

			}
		}

		return true;
	}
}