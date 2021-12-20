package MaximumLengthOfSubarrayWithPositiveProduct;
import java.util.*;

class Solution {
	public int getMaxLen(int[] nums) {
		int firstNegative = -1, zeroPosition = -1, numOfNegatives = 0, max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				numOfNegatives++;
				if (firstNegative == -1) {
					firstNegative = i;
				}
			}
			if (nums[i] == 0) {
				numOfNegatives = 0;
				firstNegative = -1;
				zeroPosition = i;
			} else {
				if (numOfNegatives % 2 == 0) {
					max = Math.max(i - zeroPosition, max);
				} else {
					max = Math.max(i - firstNegative, max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.getMaxLen(new int[]{-1, -2, 3, 0, 1, -1, -1, -4, 5, 9});
	}
}