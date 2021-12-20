package RemoveDuplicateFromSortedArray;

class Solution {
	public int removeDuplicates(int[] nums) {
		int write = 0;
		int read = 1;

		while (read < nums.length) {

			while (read < nums.length && nums[write] == nums[read]) {
				read++;
			}
			if (read < nums.length) {
				nums[write + 1] = nums[read];
				write++;
			}

		}

		return write + 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
	}
}

//class Solution {
//	public int removeDuplicates(int[] nums) {
//		int k = nums.length;
//
//		for (int i = 1; i < k; i++) {
//			if (nums[i] == nums[i - 1]) {
//				shiftOneLeft(nums, i - 1, k);
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
//		test.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
//	}
//}