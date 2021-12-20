package MaximumProductOfThreeNumbers;
import java.util.*;


class Solution {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);

		int a = nums[0] * nums[1] * nums[nums.length - 1];
		int b = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];

		return a > b ? a : b;
	}
}