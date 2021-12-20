package MoveZeroes;

class Solution {
	public void moveZeroes(int[] nums) {
		int write = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[write] = nums[i];
				write++;
			}
		}

		while (write < nums.length) {
			nums[write] = 0;
			write++;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.moveZeroes(new int[]{0,1,0,3,12});
	}
}
//
//class Solution {
//	public static void moveZeroes(int[] nums) {
//		int write = 0;
//		int read = 1;
//
//		if (nums.length == 1) return;
//
//		while (read < nums.length) {
//			if (nums[read] == 0 && nums[write] == 0) {
//				read++;
//			} else if (nums[read] == 0 && nums[write] != 0) {
//				read++;
//				write++;
//			} else if (nums[write] == 0){
//				nums[write] = nums[read];
//				nums[read] = 0;
//				write++;
//				read++;
//			} else {
//				write++;
//				read++;
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		moveZeroes(new int[]{1,0,1});
//	}
//}