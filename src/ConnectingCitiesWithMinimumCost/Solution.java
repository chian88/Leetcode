package ConnectingCitiesWithMinimumCost;

import java.util.Arrays;

class UnionFind {
	private int[] weights;
	private int[] parents;

	public void Union(int a, int b) {
		int rootA = Find(a);
		int rootB = Find(b);


	}

	public int Find(int a) {
		while (a != this.parents[a]) {
			this.parents[a] = this.parents[parents[a]];
			a = this.parents[a];
		}

		return a;
	}

	public boolean isInSameGroup (int a, int b) {
		return Find(a) == Find(b);
	}

	UnionFind(int N) {
		this.parents = new int[N + 1];
		this.weights = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			this.parents[i] = i;
			this.weights[i] = i;
		}
	}
}


public class Solution {
	public int minimumCost(int n, int[][] connections) {
		UnionFind uf = new UnionFind(n);

		Arrays.sort(connections, (a, b) -> {
			return a[2] - b[2];
		});

		int totalEdges = 0;
		int totalCost = 0;

		for (int i = 0; i < connections.length; i++) {
			int a = connections[i][0];
			int b = connections[i][1];

			if (uf.isInSameGroup(a, b)) {
				continue;
			}

			uf.Union(a, b);

			totalCost += connections[i][2];
			totalEdges++;
		}

		if (totalEdges == n - 1) {
			return totalCost;
		} else {
			return -1;
		}
	}



}
