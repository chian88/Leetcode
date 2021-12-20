package MinimumLimitOfBallsInABag;

import java.util.*;
import java.util.PriorityQueue;

class Solution {
	boolean canFit(int[] nums, int limit, int maxOperations) {
		int operations = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > limit) {
				operations += nums[i] / limit;

				if (nums[i] % limit == 0) {
					operations--;
				}
			}
		}

		return operations <= maxOperations;
	}

	public int minimumSize(int[] nums, int maxOperations) {
		int lo = 1;
		int hi = Integer.MAX_VALUE;



		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (canFit(nums, mid, maxOperations)) {
				hi = mid;

			} else {
				lo = mid + 1;
			}

		}
		return lo;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minimumSize(new int[]{2,4,8,2}, 4);
	}
}