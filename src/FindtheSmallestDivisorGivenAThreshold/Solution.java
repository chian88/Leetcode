package FindtheSmallestDivisorGivenAThreshold;
import java.util.*;

class Solution {
	public int smallestDivisor(int[] nums, int threshold) {
		int smallest = 1;

		int largest = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			largest = Math.max(largest, nums[i]);
		}

		while (smallest < largest) {
			int mid = smallest + (largest - smallest) / 2;
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += (int) Math.ceil(nums[i] * 1.0 / mid);
			}

			if (sum > threshold) {
				smallest = mid + 1;
			} else {
				largest = mid;
			}
		}

		return smallest;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.smallestDivisor(new int[]{1,2,5,9}, 6);
	}
}