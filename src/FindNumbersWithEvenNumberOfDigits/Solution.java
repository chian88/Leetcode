package FindNumbersWithEvenNumberOfDigits;
import java.util.*;

class Solution {
	public int findNumbers(int[] nums) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int digitCount = countDigit(nums[i]);

			if (digitCount % 2 == 0) {
				count += 1;
			}
		}

		return count;
	}

	public int countDigit(int num) {
		int count = 0;

		while (num > 0) {
			count += 1;
			num = num / 10;
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findNumbers(new int[]{12,345,2,6,7896});
	}
}