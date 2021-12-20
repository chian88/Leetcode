package CheapestFlightsWithinKStops;
import java.util.*;

class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<int[]>> flightPath = new HashMap<>();

		for (int[] flight : flights) {
			flightPath.putIfAbsent(flight[0], new ArrayList<>());
			// city , cost.
			flightPath.get(flight[0]).add(new int[]{flight[1], flight[2]});
		}


		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int[] distance = new int[n];
		int[] steps = new int[n];

		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(steps, Integer.MAX_VALUE);

		distance[src] = 0;
		steps[src] = 0;


		// city, cost, steps
		heap.add(new int[]{src, 0, 0});

		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			int costSofar = curr[1];
			int stepsSoFar = curr[2];
			int currCity = curr[0];


			if (currCity == dst) {
				return costSofar;
			}

			if (stepsSoFar == k + 1) {
				continue;
			}

			List<int[]> neighbors = flightPath.get(currCity);
			if (neighbors == null) {
				continue;
			}

			for (int[] neighbor : neighbors) {
				int neighborCity = neighbor[0];
				int neighborCost = neighbor[1];

				if (costSofar + neighborCost < distance[neighborCity]) {
					heap.add(new int[]{neighborCity, costSofar + neighborCost, stepsSoFar + 1});
					distance[neighborCity] = costSofar + neighborCost;

				} else if (stepsSoFar < steps[neighborCity]) {
					heap.add(new int[]{neighborCity, costSofar + neighborCost, stepsSoFar + 1});
				}

				distance[neighborCity] = stepsSoFar;
			}
		}

		return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
	}
}