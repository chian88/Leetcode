package MaxSlidingWindows;
import java.util.*;


class Solution {
	private ArrayDeque<Integer> deque = new ArrayDeque<>();

	private void clearDeque(int i, int k, int[] nums) {

		if (!deque.isEmpty() && (i - k) == deque.peekFirst()) {
			deque.removeFirst();
		}

		while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
			deque.removeLast();
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length * k == 0) return new int[]{};
		if (k == 1) return nums;
		int[] output = new int[nums.length - k + 1];
		int maxIdx = 0;
		for (int i = 0; i < k; i++) {
			clearDeque(i, k, nums);

			deque.addLast(i);
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}

		output[0] = nums[maxIdx];

		for (int i = k; i < nums.length; i++) {
			clearDeque(i, k, nums);
			deque.addLast(i);

			output[i - k + 1] = nums[deque.peekFirst()];
		}
		return output;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
	}
}