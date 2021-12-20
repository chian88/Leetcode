package Find132pattern;
import java.util.*;

class Solution {
	public boolean find132pattern(int[] nums) {
		Deque<Integer> stack = new ArrayDeque<>();
		if (nums.length <= 2) {
			return false;
		}

		int[] min = new int[nums.length];

		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			minValue = Math.min(minValue, nums[i]);
			min[i] = minValue;
		}

		for (int j = nums.length - 1; j >= 0; j--) {
			if (nums[j] > min[j]) {
				while (!stack.isEmpty() && stack.peekFirst() <= min[j]) {
					stack.pollFirst();
				}

				if (!stack.isEmpty() && stack.peekFirst() < nums[j]) {
					return true;
				}

				stack.addFirst(nums[j]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
//		test.find132pattern(new int[]{3,5,0,3,4});
		test.find132pattern(new int[]{6,12,3,4,6,11,20});
	}
}