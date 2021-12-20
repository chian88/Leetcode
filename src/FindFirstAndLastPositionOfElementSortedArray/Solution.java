package FindFirstAndLastPositionOfElementSortedArray;
import java.util.*;

class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.fill(res, -1);
		if (nums.length == 0) {
			return res;
		}

		findLeftBound(nums, target, res, 0, nums.length);
		findRightBound(nums, target, res, 0, nums.length);
		return res;
	}

	void findLeftBound(int[] nums, int target, int[] res, int lo, int hi) {
		if (hi <=lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		if (nums[mid] == target) {
			res[0] = mid;
			findLeftBound(nums, target, res, lo, mid);
		} else if (nums[mid] > target ) {
			findLeftBound(nums, target, res, lo, mid);
		} else {
			findLeftBound(nums, target, res, mid + 1, hi);
		}
	}

	void findRightBound(int[] nums, int target, int[] res, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		if (nums[mid] == target) {
			res[1] = mid;
			findRightBound(nums, target, res, mid + 1, hi);
		} else if (nums[mid] < target ) {
			findRightBound(nums, target, res, mid + 1, hi);
		} else {
			findRightBound(nums, target, res, lo, mid);
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.searchRange(new int[]{5,7,7,8,8,10}, 8);
	}
}