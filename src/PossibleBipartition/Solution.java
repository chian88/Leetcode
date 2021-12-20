package PossibleBipartition;
import java.util.*;


class Solution {
	public boolean possibleBipartition(int n, int[][] dislikes) {

		ArrayList<Integer>[] graph = new ArrayList[n + 1];

		for (int[] dislike : dislikes) {
			if (graph[dislike[0]] == null) {
				graph[dislike[0]] = new ArrayList<>();
			}
			graph[dislike[0]].add(dislike[1]);

			if (graph[dislike[1]] == null) {
				graph[dislike[1]] = new ArrayList<>();
			}

			graph[dislike[1]].add(dislike[0]);
		}

		int[] color = new int[n + 1];
		Arrays.fill(color, -1);
		for (int i = 1; i <= n; i++) {
			if (color[i] == -1) {
				// start bfs
				Deque<Integer> q = new ArrayDeque<>();
				q.addFirst(i);
				color[i] = 1;

				while (!q.isEmpty()) {
					int curr = q.pollLast();

					List<Integer> neis = graph[curr];

					if (neis == null) {
						continue;
					}

					for (int nei : neis) {
						if (color[nei] == -1) {
							color[nei] = 1 - color[curr];
							q.addFirst(nei);
						} else if (color[nei] == color[curr]) {
							return false;
						}
					}
				}
			}
		}


		return true;
	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("01"));
	}
}