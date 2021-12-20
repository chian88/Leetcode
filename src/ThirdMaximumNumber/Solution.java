package ThirdMaximumNumber;
import java.util.*;

class Solution {
	public int thirdMax(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for (int num : nums) {
			if (max1 == null) {
				max1 = num;
			} else if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (num == max1) {
				continue;
			} else if (max2 == null) {
				max2 = num;
			} else if (num > max2) {
				max3 = max2;
				max2 = num;
			} else if (num == max2) {
				continue;
			} else if (max3 == null) {
				max3 = num;
			} else if (num > max3) {
				max3 = num;
			} else if (num == max3) {
				continue;
			}
		}

		if (max3 == null) {
			return max1;
		}

		return max3;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.thirdMax(new int[]{2,2,3,1});
	}
}