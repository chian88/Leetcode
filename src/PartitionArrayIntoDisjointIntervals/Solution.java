package PartitionArrayIntoDisjointIntervals;
import java.util.*;

class Solution {
	public int partitionDisjoint(int[] nums) {
		int[] maxLeft = new int[nums.length];
		int[] minRight = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				maxLeft[i] = nums[i];
			} else {
				maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				minRight[i] = nums[i];
			} else {
				minRight[i] = Math.min(minRight[i + 1], nums[i]);
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (maxLeft[i - 1] <= minRight[i]) {
				return i;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.partitionDisjoint(new int[]{6,0,8,30,37,6,75,98,39,90,63,74,52,92,64});
	}
}