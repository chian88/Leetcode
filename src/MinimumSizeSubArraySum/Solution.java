package MinimumSizeSubArraySum;
import java.util.*;


class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int left = -1;
		int right = 0;
		int sum = nums[0];
		int res = Integer.MAX_VALUE;
		while (right < nums.length) {
			if (sum >= target) {
				res = Math.min(res, right - left);
				left++;
				sum -= nums[left];
			} else {
				right++;
				if (right < nums.length) {
					sum += nums[right];
				}

			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
	}
}








//class Solution {
//	public int minSubArrayLen(int target, int[] nums) {
//		int cummSum = nums[0];
//		int minSubArrayLen = Integer.MAX_VALUE;
//		int start = 0;
//		int end = 0;
//
//		while (end < nums.length) {
//			if (cummSum >= target) {
//				minSubArrayLen = Math.min(minSubArrayLen, end - start + 1);
//				cummSum -= nums[start];
//				start += 1;
//
//			} else {
//				end += 1;
//				if (end == nums.length) break;
//				cummSum += nums[end];
//
//
//			}
//		}
//
//		return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
//	}
//}