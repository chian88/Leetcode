package ThreeSumSmaller;
import java.util.*;

class Solution {
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int p = i + 1; p < nums.length - 1; p++) {
				for (int q = p + 1; q < nums.length; q++) {
					int sum = nums[i] + nums[p] + nums[q];
					if (sum < target) {
						res++;
					} else {
						break;

					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.threeSumSmaller(new int[]{3,1,0,-2}, 4);
	}
}