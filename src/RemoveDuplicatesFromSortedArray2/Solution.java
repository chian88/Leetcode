package RemoveDuplicatesFromSortedArray2;

class Solution {
	public int removeDuplicates(int[] nums) {
		int count = 0;
		int read = 0;
		int write = 0;
		int prev = 0;

		while (read < nums.length) {
			if (count == 2 && nums[read] == nums[write - 1]) {
				while (read < nums.length && nums[read] <= nums[write - 1]) {
					read++;
				}
				if (read < nums.length) {
					nums[write] = nums[read];
					count = 1;
					read++;
					write++;
				}

			} else if (write == 0 || nums[read] == nums[write - 1]) {
				count++;
				nums[write] = nums[read];
				read++;
				write++;
			} else if (nums[write - 1] != nums[read]) {
				count = 1;
				nums[write] = nums[read];
				read++;
				write++;
			}
		}

		return write;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeDuplicates(new int[]{1,1,1});
	}
}
