package LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;
import java.util.*;

class Solution {
	public int longestSubarray(int[] nums, int limit) {
		Deque<Integer> maxd = new ArrayDeque<>();
		Deque<Integer> mind = new ArrayDeque<>();
		int i = 0, j;
		for (j = 0; j < nums.length; ++j) {
			while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) {
				maxd.pollLast();
			}
			while (!mind.isEmpty() && nums[j] < mind.peekLast()) {
				mind.pollLast();
			}
			maxd.add(nums[j]);
			mind.add(nums[j]);
			if (maxd.peek() - mind.peek() > limit) {
				if (maxd.peek() == nums[i]) maxd.poll();
				if (mind.peek() == nums[i]) mind.poll();
				++i;
			}
		}
		return j - i;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestSubarray(new int[]{10,1,2,4,7,2}, 5);
	}
}