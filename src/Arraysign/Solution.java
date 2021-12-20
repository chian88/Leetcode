package Arraysign;

class Solution {
	public int arraySign(int[] nums) {
		int countOfNegative = 0;
		boolean gotZero = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) countOfNegative++;
			if (nums[i] == 0) gotZero = true;
		}

		if (gotZero) return 0;

		if (countOfNegative % 2 == 0) {
			return 1;
		} else {
			return -1;
		}
	}
}