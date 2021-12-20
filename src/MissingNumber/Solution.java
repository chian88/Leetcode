package MissingNumber;
import java.util.*;

class Solution {
	public int missingNumber(int[] nums) {
		boolean foundZero = false;

		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i]) == 0) {
				foundZero = true;
			} else {
				nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
			}

		}

		if (foundZero == false) {
			return 0;
		} else {
			int target = -1;
			int zeroIndx = -1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					zeroIndx = i + 1;
				}

				if (nums[i] > 0) {
					target = i + 1;
				}
			}

			if (target == -1) {
				return zeroIndx;
			} else {
				return target;
			}
		}
	}
}