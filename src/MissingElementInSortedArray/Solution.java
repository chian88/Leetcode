package MissingElementInSortedArray;
import java.util.*;

class Solution {
	public int missingElement(int[] nums, int k) {
		int missingNum = nums[nums.length - 1] - nums[0] - nums.length - 1;
		if (k > missingNum) {
			return nums[nums.length - 1] + k - missingNum;
		}


		return binarySearch(nums, k, 0, nums.length - 1);
	}

	int binarySearch(int[] nums, int k, int left, int right) {
		if (right <= left) {
			int missingNum = nums[left - 1] - nums[0] - (left - 1);
			int ans = nums[left - 1] + k - missingNum;
			return ans;
		}

		int mid = left + (right - left) / 2;
		int missingNum = nums[mid] - nums[0] - mid;

		if (k > missingNum) {
			return binarySearch(nums, k, mid + 1, right);
		} else {
			return binarySearch(nums, k, left, mid);
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.missingElement(new int[]{4,7,9,10}, 3);
	}
}