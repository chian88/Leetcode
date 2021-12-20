package NumberOfOperationsToMakeNetworkConnected;
import java.util.*;


class UnionFind {
	int[] parents;

	int find(int a) {
		if (parents[a] != a) {
			parents[a] = find(parents[a]);
		}

		return parents[a];
	}

	boolean isSameGroup(int a, int b) {
		return find(a) == find(b);
	}

	void union (int a, int b) {
		parents[find(a)] = find(b);
	}


	UnionFind(int n ) {
		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
}

class Solution {
	public int makeConnected(int n, int[][] connections) {
		UnionFind uf = new UnionFind(n);
		int redundantConnections = 0;
		int connectionsMade = 0;
		for (int[] connection : connections) {
			if (!uf.isSameGroup(connection[0], connection[1])) {
				uf.union(connection[0], connection[1]);
				connectionsMade += 1;
			} else {
				redundantConnections += 1;
			}
		}

		int requiredConnection = n - 1 - connectionsMade;

		if (redundantConnections < requiredConnection) {
			return -1;
		}

		return requiredConnection;
	}
}