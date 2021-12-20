package MaximizeDistanceToClosestPerson;
import java.util.*;

class Solution {
	public int maxDistToClosest(int[] seats) {
		int[] left = new int[seats.length];
		int[] right = new int[seats.length];

		Arrays.fill(left, -1);
		Arrays.fill(right, -1);

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				left[i] = 0;
			} else if (i - 1 >= 0 && left[i - 1] != -1) {
				left[i] = left[i - 1] + 1;
			}
		}

		for (int i = seats.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				right[i] = 0;
			} else if (i + 1 < seats.length && right[i + 1] != -1) {
				right[i] = right[i + 1] + 1;
			}
		}
		int maxDist = Integer.MIN_VALUE;
		for (int i = 0; i < seats.length; i++) {
			Integer minDist = null;
			if (left[i] == -1) {
				minDist = right[i];
			} else if (right[i] == -1) {
				minDist = left[i];
			} else {
				minDist = Math.min(left[i], right[i]);
			}

			if (minDist > maxDist) {
				maxDist = minDist;
			}
		}

		return maxDist;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxDistToClosest(new int[]{0,1});
	}
}