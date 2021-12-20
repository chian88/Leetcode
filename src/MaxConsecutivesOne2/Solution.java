package MaxConsecutivesOne2;
import java.util.*;

class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int running = 0;
		for (int i = 0; i < nums.length; i++) {
			left[i] = running;
			if (nums[i] == 0) {
				running = 0;
			} else {
				running += 1;
			}


		}
		running = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			right[i] = running;
			if (nums[i] == 0) {
				running = 0;
			} else {
				running += 1;
			}

		}
		running = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				res = Math.max(res, left[i] + right[i] + 1);
				running = 0;
			} else {
				running += 1;
				res = Math.max(res, running);
			}



		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,0});
	}
}