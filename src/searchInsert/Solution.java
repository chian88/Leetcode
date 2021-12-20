package searchInsert;
import java.util.*;

class Solution {
	public static int searchInsert(int[] nums, int target) {
		return searchInsertHelper(nums, target, 0, nums.length);
	}

	private static  int searchInsertHelper(int[] nums, int target, int low, int high) {
		if (high <= low) return low;


		int midIdx = low + ((high - low) / 2);


		if (nums[midIdx] == target) {
			return midIdx;
		} else if (nums[midIdx] > target) {
			// go left
			return searchInsertHelper(nums, target, low , midIdx);
		} else {
			return searchInsertHelper(nums, target, midIdx + 1, high);
		}
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5}, 9));
	}
}