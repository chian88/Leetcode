package RedundantConnection;
import java.util.*;

class UnionFind {
	int[] parent;

	UnionFind(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	void join(int a, int b) {
		parent[find(a)] = find(b);
	}

	int find(int x ) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	boolean same(int a, int b) {
		return find(a) == find(b);
	}
}


class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		UnionFind uf = new UnionFind(edges.length);

		for (int[] edge : edges) {
			if (uf.same(edge[0], edge[1])) {
				return edge;
			} else {
				uf.join(edge[0], edge[1]);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}});
	}
}