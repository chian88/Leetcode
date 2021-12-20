package BuildingArrayFromPermutation;
import java.util.*;

class Solution {
	public int[] buildArray(int[] nums) {
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			res[i] = nums[nums[i]];
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.buildArray(new int[]{0,2,1,5,3,4});
	}
}