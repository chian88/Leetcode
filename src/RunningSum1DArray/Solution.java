package RunningSum1DArray;

public class Solution {
	public int[] runningSum(int[] nums) {
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			nums[i] = runningSum;
		}
		return nums;
	}
}
