package GraphValidTree;
import java.util.*;

class UnionFind {
	int[] parents;

	UnionFind(int n) {
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	int find(int x) {

		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}

		return parents[x];
	}

	void union(int x, int y) {
		parents[find(x)] = find(y);
	}
}

class Solution {
	public boolean validTree(int n, int[][] edges) {
		if (edges.length != n - 1) {
			return false;
		}

		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}

		Set<Integer> uniq = new HashSet<>();

		for (int i = 0; i < n; i++) {
			uniq.add(uf.find(i));
		}

		return uniq.size() == 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.validTree(5, new int[][]{{0,1}, {0,2}, {0,3}, {1,4}});
	}
}