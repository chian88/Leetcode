package ShuffleTheArray;

class Solution {
	public int[] shuffle(int[] nums, int n) {
		int[] res = new int[nums.length];

		int secondPtr = nums.length / 2;
		int ptr = 0;
		for (int i = 0; i < nums.length / 2; i++) {
			res[ptr] = nums[i];
			res[ptr + 1] = nums[secondPtr];
			secondPtr++;
			ptr += 2;
		}

		return res;
	}
}