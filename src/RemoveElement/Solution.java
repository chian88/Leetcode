package RemoveElement;
import java.util.*;

class Solution {
	public int removeElement(int[] nums, int val) {
		int k = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeElement(new int[]{3,2,2,3}, 3);
	}
}












//class Solution {
//	public int removeElement(int[] nums, int val) {
//		int k = nums.length;
//
//		for (int i = 0; i < k; i++) {
//			if (nums[i] == val) {
//				shiftOneLeft(nums, i, k);
//				k--;
//				i--;
//			}
//		}
//		return k;
//	}
//
//	private void shiftOneLeft(int[] nums, int start, int k) {
//		for (int i = start; i < k - 1; i++) {
//			nums[i] = nums[i + 1];
//		}
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
//	}
//}