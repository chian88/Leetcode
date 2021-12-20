package FirstMissingPositive;
import java.util.*;

class Solution {
	public int firstMissingPositive(int[] nums) {
		boolean foundOne = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) foundOne = true;
		}

		if (foundOne == false) return 1;

		int n = nums.length;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]);

			if (idx == n) {
				nums[0] = - Math.abs(nums[0]);
			} else {
				nums[idx] = - Math.abs(nums[idx]);
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i;
			}
		}

		if (nums[0] > 0) return n;
		return n + 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.firstMissingPositive(new int[]{3,4,-1,1});
	}
}