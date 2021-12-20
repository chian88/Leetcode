package FindPeakElement;
import java.util.*;


class Solution {
	public int findPeakElement(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;

		if (nums.length == 1) return 0;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[mid + 1]) {
				// go left
				hi = mid;
			} else {
				// go right
				lo = mid + 1;
			}
		}

		return lo;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findPeakElement(new int[] {1,2});
	}
}
