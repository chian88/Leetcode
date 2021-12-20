package SatisfiabilityOfEqualityEquations;
import java.util.*;


class UnionFind {
	int[] parent = new int[26];

	UnionFind() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	void union(int x, int y) {
		parent[find(x)] = find(y);
	}
}

class Solution {
	public boolean equationsPossible(String[] equations) {
		UnionFind uf = new UnionFind();
		for (String equation : equations) {
			char first = equation.charAt(0);
			char last = equation.charAt(equation.length() - 1);
			if (equation.indexOf("==") != -1) {
				// union
				uf.union(first - 'a', last - 'a');
			}
		}

		for (String equation : equations) {
			char first = equation.charAt(0);
			char last = equation.charAt(equation.length() - 1);
			if (equation.indexOf("!=") != -1) {
				if (uf.find(first - 'a') == uf.find(last - 'a')) {
					return false;
				}
			}

		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.equationsPossible(new String[]{"a==b", "b!=c", "c==a" });
	}


}