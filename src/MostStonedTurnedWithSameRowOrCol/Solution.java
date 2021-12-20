package MostStonedTurnedWithSameRowOrCol;
import java.util.*;



class Solution {
	public int removeStones(int[][] stones) {
		UnionFind uf = new UnionFind();
		for (int[] stone : stones) {
			uf.create(new Pair(stone[0], stone[1]));
		}

		for (int i = 0; i < stones.length; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				Pair one = new Pair(stones[i][0], stones[i][1]);
				Pair two = new Pair(stones[j][0], stones[j][1]);

				if (one.i == two.i || one.j == two.j) {
					uf.union(one, two);
				}
			}
		}
		Map<Pair, Pair> parents = uf.parents;

		Set<Pair> parentSet = new HashSet<>();

		for (Map.Entry<Pair, Pair> entry : parents.entrySet()) {
			parentSet.add(uf.find(entry.getKey()));
		}


		return stones.length - parentSet.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeStones(new int[][]{{0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}});
	}
}

class Pair {
	int i;
	int j;

	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return i == pair.i && j == pair.j;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}
}

class UnionFind {
	Map<Pair, Pair> parents = new HashMap<>();

	void create(Pair x) {
		parents.put(x, x);
	}

	Pair find(Pair x) {
		if (parents.get(x) != x) {
			parents.put(x, find(parents.get(x)));
		}

		return parents.get(x);
	}

	void union(Pair one, Pair two) {
		parents.put(find(one), find(two));
	}
}