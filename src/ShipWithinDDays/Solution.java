package ShipWithinDDays;
import java.util.*;


class Solution {
	public int shipWithinDays(int[] weights, int days) {
		int upper = 0;
		int lower = 0;
		int res = 0;

		for (int weight : weights) {
			upper += weight;
			lower = Math.max(lower, weight);
		}

		while (lower <= upper) {
			int mid = lower + (upper - lower) / 2;

			if(canFit(weights, mid, days)){
				res = mid;
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}

		return res;

	}

	private boolean canFit(int[] weights, int capacity, int days) {
		int ptr = 0;
		int runningSum = 0;
		while (ptr < weights.length && days > 0 ) {
			if (runningSum + weights[ptr] <= capacity) {
				runningSum += weights[ptr];
				ptr++;
			} else {
				runningSum = 0;
				days -= 1;
			}

		}

		return days >= 0 && ptr == weights.length;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.shipWithinDays(new int[]{10,50,100,100,50,100,100,100}, 5);
	}
}