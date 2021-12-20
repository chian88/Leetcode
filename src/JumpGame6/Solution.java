package JumpGame6;
import java.util.*;

class Solution {
	public int maxResult(int[] nums, int k) {
		int[] score = new int[nums.length];
		score[0] = nums[0];

		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(0);

		for (int i = 1 ; i < nums.length; i++) {
			while (!deque.isEmpty() && deque.peekFirst() < (i - k)) {
				deque.pollFirst();
			}

			int max = nums[i] + score[deque.peekFirst()];
			score[i] = max;
			while (!deque.isEmpty() && score[deque.peekLast()] < max) {
				deque.pollLast();
			}
			deque.addLast(i);
		}

		return score[score.length - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
	}
}