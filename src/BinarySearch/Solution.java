package BinarySearch;
import java.util.*;


class Solution {
	public int search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length;



		while (lo < hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == target) return mid;

			if (nums[mid] > target) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.search(new int[] {-1,0,3,5,9,12}, 12);
	}
}