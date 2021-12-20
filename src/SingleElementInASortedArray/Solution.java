package SingleElementInASortedArray;
import java.util.*;

class Solution {
	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 1) return nums[0];
		int lo = 0;
		int hi = nums.length;
		int mid = 0;
		while (lo < hi) {
			mid = lo + (hi - lo) / 2;
			if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
				if ((hi - (mid + 2)) % 2 == 1 ) {
					// go right
					lo = mid + 2;
				} else {
					hi = mid ;
				}
			} else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
				if ((mid - 1 - lo) % 2 == 1) {
					// go left
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				return nums[mid];
			}
		}

		return nums[lo];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.singleNonDuplicate(new int[]{1,1,2});
	}
}