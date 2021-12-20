package ShortestPathWithAlternatingColors;
import java.util.*;

class Solution {
	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		Map<Integer, List<Integer>> redGraph = new HashMap<>();
		Map<Integer, List<Integer>> blueGraph = new HashMap<>();

		for (int[] red_edge : red_edges) {
			redGraph.putIfAbsent(red_edge[0], new ArrayList<>());
			redGraph.get(red_edge[0]).add(red_edge[1]);
		}

		for (int[] blue_edge : blue_edges) {
			blueGraph.putIfAbsent(blue_edge[0], new ArrayList<>());
			blueGraph.get(blue_edge[0]).add(blue_edge[1]);
		}
		int[] res = new int[n];
		res[0] = 0;

		// queue , int[0] is curr vertex, int[1] is 0 is red, 1 is blue.
		for (int to = 1; to < n; to++) {
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{0, 0});
			q.add(new int[]{0, 1});


			Set<Integer> visitedFromBlue = new HashSet<>();
			Set<Integer> visitedFromRed = new HashSet<>();
			visitedFromBlue.add(0);
			visitedFromRed.add(0);
			int dist = 0;
			boolean found = false;
			while (!q.isEmpty()) {
				int levelSize = q.size();
				while (levelSize > 0) {
					int[] curr = q.poll();
					// red
					if (curr[1] == 0 && blueGraph.containsKey(curr[0])) {
						List<Integer> nexts = blueGraph.get(curr[0]);
						if (nexts == null) {
							continue;
						}
						for (int next : nexts) {
							if (next == to) {
								found = true;
								res[to] = dist + 1;
								break;
							}

							if (!visitedFromBlue.contains(next)) {
								visitedFromBlue.add(next);
								q.add(new int[]{next, 1});
							}
						}

					}
					// blue
					if (curr[1] == 1 && redGraph.containsKey(curr[0])) {
						List<Integer> nexts = redGraph.get(curr[0]);

						if (nexts == null) {
							continue;
						}

						for (int next : nexts) {
							if (next == to) {
								found = true;
								res[to] = dist + 1;
								break;
							}

							if (!visitedFromRed.contains(next)) {
								visitedFromRed.add(next);
								q.add(new int[]{next, 0});
							}
						}
					}

					if (found) {
						break;
					}

					levelSize--;
				}
				if (found) {
					break;
				}

				dist++;
			}

			if (!found) {
				res[to] = -1;
			}


		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.shortestAlternatingPaths(3, new int[][]{{0,1}, {0,2}}, new int[][]{{1,0}});
	}
}