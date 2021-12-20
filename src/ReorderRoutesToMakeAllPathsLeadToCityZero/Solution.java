package ReorderRoutesToMakeAllPathsLeadToCityZero;
import java.util.*;


class Solution {
	public int minReorder(int n, int[][] connections) {
		List<Integer>[] roadOut = new ArrayList[n];

		for (int[] connection : connections) {
			if (roadOut[connection[0]] == null) {
				roadOut[connection[0]] = new ArrayList<>();
			}

			roadOut[connection[0]].add(connection[1]);
		}

		List<Integer>[] roadIn = new ArrayList[n];

		for (int[] connection : connections) {
			if (roadIn[connection[1]] == null) {
				roadIn[connection[1]] = new ArrayList<>();
			}

			roadIn[connection[1]].add(connection[0]);
		}


		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		q.add(0);
		int res = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();

			List<Integer> outs = roadOut[curr];

			if (outs != null) {
				for (int out : outs) {
					if (!visited.contains(out)) {
						q.add(out);
						visited.add(out);
						res++;
					}

				}
			}

			List<Integer> ins = roadIn[curr];

			if (ins != null) {
				for (int in : ins) {
					if (!visited.contains(in)) {
						visited.add(in);
						q.add(in);
					}

				}
			}
		}

		return res;
	}
}