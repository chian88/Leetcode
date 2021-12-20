package NonDecreasingArray;
import java.util.*;

class Solution {
	public boolean checkPossibility(int[] nums) {
		int numViolation = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] >  nums[i]) {
				if (numViolation == 1) {
					return false;
				}

				numViolation++;

				if (i < 2 || nums[i - 2] <= nums[i]) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
			}
		}

		return true;
	}
}