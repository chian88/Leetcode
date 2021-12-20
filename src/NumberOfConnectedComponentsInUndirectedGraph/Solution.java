package NumberOfConnectedComponentsInUndirectedGraph;
import java.util.*;

class Solution {
	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}

		Set<Integer> connectedComponents = new HashSet<>();
		for (int i = 0; i < n; i++) {
			connectedComponents.add(uf.find(i));
		}

		return connectedComponents.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countComponents(5, new int[][]{{0,1}, {1,2}, {3,4}});
	}

}

class UnionFind {
	int[] parents;
	UnionFind(int n) {
		this.parents = new int[n];

		for (int i = 0; i < parents.length; i++) {
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