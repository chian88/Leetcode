package FindAllNumbersDissapearedInAnArray;
import java.util.*;

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			nums[idx] = Math.abs(nums[idx]) * -1;
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}
}



















//class Solution {
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		for (int i = 0; i < nums.length; i++) {
//			int idx = Math.abs(nums[i]) - 1;
//
//			nums[idx] = Math.abs(nums[idx]) * -1;
//		}
//		List<Integer> res = new ArrayList<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] > 0) {
//				res.add(i + 1);
//			}
//		}
//
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
//	}
//}
