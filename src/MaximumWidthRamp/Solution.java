package MaximumWidthRamp;
import java.util.*;

class Solution {
	public int maxWidthRamp(int[] nums) {
		Stack<int[]> stack = new Stack<>();

		for (int i = 0 ; i < nums.length; i++) {
			if (stack.isEmpty()) {
				stack.add(new int[]{nums[i], i});
			} else if (nums[i] < stack.peek()[0]) {
				stack.add(new int[]{nums[i], i});
			}
		}
		int res = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
				res = Math.max(res, i - stack.pop()[1]);
				i++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
	}
}