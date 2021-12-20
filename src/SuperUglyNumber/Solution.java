package SuperUglyNumber;
import java.util.*;

class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		List<Integer> uglyNumbers = new ArrayList();
		uglyNumbers.add(1);
		Set<Integer> seen = new HashSet<>();
		for (int prime : primes) {
			heap.add(new int[]{prime, 0, prime});
		}
		while (uglyNumbers.size() < n) {
			int[] smallest = heap.poll();
			if (!seen.contains(smallest[0])) {
				seen.add(smallest[0]);
				uglyNumbers.add(smallest[0]);
			}

			smallest[1]++;
			smallest[0] =  uglyNumbers.get(smallest[1]) * smallest[2];

			heap.add(smallest);

		}

		return uglyNumbers.get(n-1);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.nthSuperUglyNumber(12, new int[]{2,7,13,19});
	}
}