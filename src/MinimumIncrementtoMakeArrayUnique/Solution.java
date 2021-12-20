package MinimumIncrementtoMakeArrayUnique;
import java.util.*;


class Solution {
	public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= maxSoFar) {
				int temp = nums[i];
				nums[i] = maxSoFar + 1;
				maxSoFar += 1;
				count += maxSoFar - temp;
			} else  {
				maxSoFar = nums[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minIncrementForUnique(new int[]{3,2,1,2,1,7});
	}
}