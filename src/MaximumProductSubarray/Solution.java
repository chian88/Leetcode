package MaximumProductSubarray;

class Solution {
	public static int maxProduct(int[] nums) {
		int[] sum = new int[nums.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum[i] = 0;
			} else if (i - 1 >= 0 && sum[i - 1] == 0) {
				sum[i] = nums[i];
			} else if (i - 1 >= 0) {
				sum[i] = nums[i] * sum[i - 1];
			} else {
				sum[i] = nums[i];
			}

			max = Math.max(max, sum[i]);
		}
		sum = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				sum[i] = 0;
			} else if (i + 1 < nums.length && sum[i + 1] == 0) {
				sum[i] = nums[i];
			} else if (i + 1 < nums.length) {
				sum[i] = nums[i] * sum[i + 1];
			} else {
				sum[i] = nums[i];
			}

			max = Math.max(max, sum[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		maxProduct(new int[]{2,-5,-2,-4,3});
	}
}