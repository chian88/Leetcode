package TwoCityScheduling;
import java.util.*;

class Solution {
	public int twoCitySchedCost(int[][] costs) {
		int[][] diff = new int[costs.length][2];

		for (int i = 0 ; i < costs.length; i++) {
			diff[i][0] = i;
			diff[i][1] = costs[i][0] - costs[i][1];
		}

		Arrays.sort(diff, (a, b) -> {
			return Integer.compare(a[1], b[1]);
		});
		int cost = 0;
		for (int i = 0; i < diff.length; i++) {
			if (i < diff.length / 2) {
				cost += costs[diff[i][1]][0];
			} else {
				cost += costs[diff[i][1]][1];
			}
		}

		return cost;
	}
}