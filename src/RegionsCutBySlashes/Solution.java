package RegionsCutBySlashes;
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

	int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
}

class Solution {
	public int regionsBySlashes(String[] grid) {
		int n = grid.length;
		int totalRegions = n * n * 4;

		UnionFind uf = new UnionFind(totalRegions);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				int cell = (i * n * 4) + (j * 4);


				if (grid[i].charAt(j) == ' ') {
					uf.join(cell , cell+1);
					uf.join(cell, cell + 3);
					uf.join(cell + 1, cell + 2);
					uf.join(cell + 2 , cell + 3);

				} else if (grid[i].charAt(j) == '/') {
					uf.join(cell, cell + 3);
					uf.join(cell + 1, cell + 2);
				} else if (grid[i].charAt(j) == '\\') {
					uf.join(cell, cell + 1);
					uf.join(cell + 2, cell + 3);
				}

				if (i - 1 >= 0) {
					// connect to top
					int topCell = ( (i - 1) * (n * 4)) + (j * 4);
					uf.join(cell, topCell + 2);

				}

				if (j - 1 >= 0) {
					int leftCell = (i * n * 4) + ((j - 1) * 4);
					uf.join(cell + 3, leftCell + 1);
				}

				if (j + 1 < n) {
					int rightCell = (i * n * 4) + ((j + 1) * 4);
					uf.join(cell + 1, rightCell + 3);
				}

				if (i + 1 < n) {
					int downCell = ( (i + 1) * n * 4) + (j * 4);
					uf.join(cell + 2, downCell);
				}
			}
		}

		Set<Integer> regions = new HashSet<>();

		for (int i = 0; i < totalRegions; i++) {
			regions.add(uf.find(i));
		}

		return regions.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.regionsBySlashes(new String[]{" /", "/ "});
	}
}