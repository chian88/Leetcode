package NetworkDelayTime;
import java.util.*;

class Step {
	int cost;
	int node;

	Step (int cost, int node) {
		this.cost = cost;
		this.node = node;
	}
}

class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] delay = new int[n];

		Integer[][] graph = new Integer[n][n];

		for (int[] time : times) {
			graph[time[0] - 1][time[1] - 1] = time[2];
		}


		Arrays.fill(delay, Integer.MAX_VALUE);

		PriorityQueue<Step> heap = new PriorityQueue<>(new Comparator<Step>() {
			public int compare(Step o1, Step o2) {
				return o1.cost - o2.cost;
			}
		});

		heap.add(new Step(0, k - 1));
		HashSet<Integer> visited = new HashSet<>();
		while (!heap.isEmpty()) {
			Step curr = heap.poll();
			delay[curr.node] = Math.min(delay[curr.node], curr.cost);
			for (int j = 0; j < n; j++) {
				Integer nextCost = graph[curr.node][j];
				if (!visited.contains(j) && graph[curr.node][j] != null) {
					visited.add(j);
					heap.add(new Step(curr.cost + nextCost, j));

				}
			}
		}
		int res = Integer.MIN_VALUE;
		for (int d : delay) {
			res = Math.max(res, d);
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,2}}, 3, 1);
	}
}