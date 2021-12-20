package SumOfAbsoluteDifferencesInASortedArray;
import java.util.*;

class Solution {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int[] prefixSum = new int[nums.length];
		int[] suffixSum = new int[nums.length];

		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			suffixSum[i] = suffixSum[i + 1] + nums[i + 1];
		}

		int[] res = new int[nums.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = (nums[i] * i - prefixSum[i]) + (suffixSum[i] - nums[i] * (nums.length - 1 - i));
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.getSumAbsoluteDifferences(new int[]{3,4,5,7,9});
	}
}