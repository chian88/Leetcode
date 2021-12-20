package Campusbike;
import java.util.*;

class Solution {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		List<int[]> ranking = new ArrayList<>();

		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int[] worker = workers[i];
				int[] bike = bikes[j];

				int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
				ranking.add(new int[]{i, j, dist});
			}
		}

		boolean[] workersUsed = new boolean[workers.length];
		boolean[] bikeUsed = new boolean[bikes.length];

		ranking.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int distCmp = Integer.compare(o1[2], o2[2]);

				if (distCmp != 0) {
					return distCmp;
				}

				int workerCmp = Integer.compare(o1[0], o2[0]);

				if (workerCmp != 0) {
					return workerCmp;
				}

				return Integer.compare(o1[1], o2[1]);
			}
		});
		int[] res = new int[Math.min(bikes.length, workers.length)];
		for (int k = 0; k < ranking.size(); k++) {
			int[] rank = ranking.get(k);

			if (!workersUsed[rank[0]] && !bikeUsed[rank[1]]) {
				// both not used.
				res[rank[1]] = rank[0];
				workersUsed[rank[0]] = true;
				bikeUsed[rank[1]] = true;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.assignBikes(new int[][]{{240,446},{745,948},{345,136},{341,68},{990,165},{165,580},{133,454},{113,527}}, new int[][]{{696,140},{95,393},{935,185},{767,205},{387,767},{214,960},{804,710},{956,307}});
	}
}
