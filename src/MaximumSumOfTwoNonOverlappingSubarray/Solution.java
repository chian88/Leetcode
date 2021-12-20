package MaximumSumOfTwoNonOverlappingSubarray;
import java.util.*;

class Solution {
	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		int res = 0;
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for (int i = 1; i < prefixSum.length; i ++) {
			prefixSum[i] = nums[i] + prefixSum[i - 1];
		}

		for (int i = 0; i <= nums.length - firstLen; i++) {
			int sum1 = findSum(prefixSum, i, firstLen);
			for (int j = 0; j <= nums.length - secondLen; j++) {
				if (j + secondLen > i && j < i + firstLen) {
					continue;
				}


				int sum2 = findSum(prefixSum, j, secondLen);

				res = Math.max(res, sum1 + sum2);
			}
		}

		return res;
	}

	int findSum(int[] prefixSum, int start, int len) {
		int sum = 0;

		int left = 0;

		if (start - 1 >= 0) {
			left = prefixSum[start - 1];
		}

		int right = 0;

		if (start + len - 1 < prefixSum.length) {
			right = prefixSum[start + len - 1];
		}

		return right - left;
	}

//	int findSum(int[] nums, int start, int len) {
//		int sum = 0;
//		for (int i = start; i < start + len; i++) {
//			sum += nums[i];
//		}
//		return sum;
//	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3);
	}
}