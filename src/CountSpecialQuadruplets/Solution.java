package CountSpecialQuadruplets;
import java.util.*;

class Solution {
	public int countQuadruplets(int[] nums) {
		int output= 0;
		for (int last = 3; last < nums.length; last++ ) {
			for (int secondLast = 2 ; secondLast < last; secondLast ++) {
				for (int firstLast = 1; firstLast < secondLast; firstLast++) {
					for(int lastlast = 0; lastlast < firstLast; lastlast++) {
						if (nums[lastlast] + nums[firstLast] + nums[secondLast] == nums[last]) {
							output += 1;
						}
					}
				}
			}
		}

		return output;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countQuadruplets(new int[]{1,1,1,3,5});
	}
}