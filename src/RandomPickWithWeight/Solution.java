package RandomPickWithWeight;
import java.util.*;


class Solution {
	private int[] sums;
	public Solution(int[] w) {
		sums = new int[w.length];
		sums[0] = w[0];
		for (int i = 1; i < w.length; i++) {
			sums[i] = w[i] + sums[i - 1];
		}
	}

	public int pickIndex() {
		double rand = Math.random() * sums[sums.length - 1];

		int idx = binarySearch(sums, rand);

		return idx;
	}

	public int binarySearch(int[] sums, double rand) {
		int lo = 0;
		int hi = sums.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;


			if (sums[mid] < rand) {
				// go righgt
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;

	}

	public static void main(String[] args) {
		Solution test = new Solution(new int[]{1,3,7});
		test.pickIndex();
	}
}

