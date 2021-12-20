package MinDiffThreeMoves;
import java.util.*;

class Solution {
	public int minDifference(int[] nums) {
		Arrays.sort(nums);
		if (nums.length <= 4) return 0;

		int option1 = nums[nums.length - 1] - nums[3];
		int option2 = nums[nums.length - 4] - nums[0];
		int option3 = nums[nums.length - 3] - nums[1];
		int option4 = nums[nums.length - 2] - nums[2];

		int res = Math.min(option4,Math.min(option3,Math.min(option1, option2)));

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minDifference(new int[]{0,1,1,4,6,6,6});
	}
}