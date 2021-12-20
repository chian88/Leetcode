package FindAllDuplicatesInAnArray;
import java.util.*;

class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0 ; i < nums.length; i++) {
			int num = Math.abs(nums[i]);

			if (nums[num - 1] < 0) {
				res.add(num);
			}

			nums[num - 1] = Math.abs(nums[num - 1]) * -1;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
	}
}