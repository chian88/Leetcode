package KthMissingPositiveNumber;
import java.util.*;


class Solution {
	public int findKthPositive(int[] arr, int k) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = left + (right - left) / 2;
			int missingIntegers = arr[mid] - (mid + 1);

			if (k > missingIntegers) {
				// go right
				left = mid + 1;
			} else {
				// go left.
				right = mid;
			}
		}

		if (left >= arr.length) {
			int ans =arr[arr.length - 1] - ((arr[arr.length - 1] - (arr.length)) - k );
			return ans;
		}

		int ans = arr[left] - ((arr[left] - (left)) - k );

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findKthPositive(new int[]{5,6,7,8,9}, 9);
	}
}