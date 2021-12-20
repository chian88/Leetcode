package MajorityElement2;
import java.util.*;

class Solution {
	public List<Integer> majorityElement(int[] nums) {
		Integer candidate1 = null;
		Integer candidate2 = null;

		int counter1 = 0;
		int counter2 = 0;

		for (int num : nums) {
			if (candidate1 != null && candidate1 == num) {
				counter1++;
			} else if (candidate2 != null && candidate2 == num) {
				counter2++;
			} else if (counter1 == 0) {
				candidate1 = num;
				counter1++;
			} else if (counter2 == 0) {
				candidate2 = num;
				counter2++;
			} else {
				counter1--;
				counter2--;
			}
		}

		List<Integer> res = new ArrayList<>();

		counter1 = 0;
		counter2 = 0;

		for (int num : nums) {
			if (candidate1 != null && num == candidate1) {
				counter1++;
			}

			if (candidate2 != null && num == candidate2) {
				counter2++;
			}
		}

		int n = nums.length;
		if (counter1 > n / 3) {
			res.add(candidate1);
		}

		if (counter2 > n / 3) {
			res.add(candidate2);
		}
		return res;
	}
}