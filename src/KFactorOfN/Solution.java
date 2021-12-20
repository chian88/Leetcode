package KFactorOfN;
import java.util.*;

class Solution {
	public int kthFactor(int n, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int sqrt = (int) Math.sqrt(n);
		for (int i = 1 ; i <= sqrt; i++) {
			if (n % i == 0) {
				int factor1 = i;
				int factor2 = n / i;
				heap.add(factor1);
				if (heap.size() > k) {
					heap.remove();
				}

				if (factor1 != factor2) {
					heap.add(factor2);

					if (heap.size() > k) {
						heap.remove();
					}
				}


			}
		}

		return k == heap.size() ? heap.poll() : -1;
	}
}