package NumberOfSubarraysWithBoundedMaximum;
import java.util.*;


class Solution {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		return count(nums, right) - count(nums, left - 1);
	}

	int count(int[] nums, int bound) {
		int ans = 0;
		int cur = 0;

		for (int x : nums) {
			if (x <= bound) {
				cur += 1;
			} else {
				cur = 0;
			}

			ans += cur;
		}

		return ans;
	}
}