package LargestNumberAtLeastTwiceOfOthers;
import java.util.*;

class Solution {
	public int dominantIndex(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return 0;
		}

		int[] numsSorted = nums.clone();
		Arrays.sort(numsSorted);

		if (numsSorted[numsSorted.length - 1] >= numsSorted[numsSorted.length - 2] * 2) {
			int target = numsSorted[numsSorted.length - 1];
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target) {
					return i;
				}
			}
		} else {
			return -1;
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.dominantIndex(new int[]{1,2,3,4});
	}
}