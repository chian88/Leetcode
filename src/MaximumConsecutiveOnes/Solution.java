package MaximumConsecutiveOnes;
import java.util.*;

class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int running = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = Math.max(max, running);
				running = 0;
			} else {
				running += 1;
			}
		}
		max = Math.max(max, running);
		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
	}
}


//class Solution {
//	public int findMaxConsecutiveOnes(int[] nums) {
//		int maxCount = Integer.MIN_VALUE;
//		int currentCount = 0;
//
//		for (int i = 0 ; i < nums.length; i++) {
//			if (nums[i] == 1) {
//				currentCount += 1;
//			} else {
//				currentCount = 0;
//			}
//
//			maxCount = Math.max(maxCount, currentCount);
//		}
//
//		return maxCount;
//	}
//}