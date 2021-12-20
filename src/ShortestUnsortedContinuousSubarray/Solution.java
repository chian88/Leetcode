package ShortestUnsortedContinuousSubarray;
import java.util.*;

class Pair {
	int idx;
	int num;

	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}

class Solution {
	public int findUnsortedSubarray(int[] nums) {
		Deque<Pair> leftStack = new ArrayDeque<>();

		int leftMost = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (leftStack.isEmpty()) {
				leftStack.addFirst(new Pair(i, nums[i]));
			} else if (leftStack.peekFirst().num > nums[i]) {
				while (!leftStack.isEmpty() && leftStack.peekFirst().num > nums[i]) {
					Pair prev = leftStack.pollFirst();
					leftMost = Math.min(leftMost, prev.idx);
				}

				leftStack.addFirst(new Pair(i, nums[i]));
			} else {
				leftStack.addFirst(new Pair(i, nums[i]));
			}
		}

		Deque<Pair> rightStack = new ArrayDeque<>();

		int rightMost = Integer.MIN_VALUE;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (rightStack.isEmpty()) {
				rightStack.addFirst(new Pair(i, nums[i]));
			} else if (rightStack.peekFirst().num < nums[i]) {
				while (!rightStack.isEmpty() && rightStack.peekFirst().num < nums[i]) {
					Pair post = rightStack.pollFirst();
					rightMost = Math.max(rightMost, post.idx);
				}

				rightStack.addFirst(new Pair(i, nums[i]));
			} else {
				rightStack.addFirst(new Pair(i, nums[i]));
			}
		}

		if (rightMost == Integer.MIN_VALUE || leftMost == Integer.MAX_VALUE) {
			return 0;
		}

		return rightMost - leftMost + 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
	}
}