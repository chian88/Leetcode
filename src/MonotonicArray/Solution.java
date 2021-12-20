package MonotonicArray;
import java.util.*;

class Solution {
	public boolean isMonotonic(int[] nums) {
		if (nums.length == 1) {
			return true;
		}

		Boolean increasing = null;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1] && increasing == null) {
				increasing = true;
			} else if (nums[i] < nums[i + 1] && increasing == false) {
				return false;
			} else if (nums[i] > nums[i + 1] && increasing == null) {
				increasing = false;
			} else if (nums[i] > nums[i + 1] && increasing == true) {
				return false;
			}
		}

		return true;
	}
}