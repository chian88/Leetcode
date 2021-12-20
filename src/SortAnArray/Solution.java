package SortAnArray;
import java.util.*;


class Solution {
	public int[] sortArray(int[] nums) {
		return recursion(nums, 0, nums.length - 1);
	}

	int[] recursion(int[] nums, int left, int right) {
		if (right <= left) {
			return new int[]{nums[left]};
		}

		int mid = left + (right - left) / 2;

		int[] leftSorted = recursion(nums, left , mid);
		int[] rightSorted = recursion(nums, mid + 1, right);


		int[] res = new int[leftSorted.length + rightSorted.length];

		int ptr = 0;
		int leftPtr = 0;
		int rightPtr = 0;

		while(leftPtr < leftSorted.length && rightPtr < rightSorted.length) {
			if (leftSorted[leftPtr] <= rightSorted[rightPtr]) {
				res[ptr++] = leftSorted[leftPtr++];
			} else {
				res[ptr++] = rightSorted[rightPtr++];
			}
		}

		while (leftPtr < leftSorted.length) {
			res[ptr++] = leftSorted[leftPtr++];
		}

		while (rightPtr < rightSorted.length) {
			res[ptr++] = rightSorted[rightPtr++];
		}
		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sortArray(new int[]{5,1,1,2,0,0});
	}
}