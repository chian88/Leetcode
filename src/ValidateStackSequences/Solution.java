package ValidateStackSequences;

import java.util.*;

class Solution {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int p1 = 0;
		int p2 = 0;

		Deque<Integer> stack = new ArrayDeque<>();

		stack.addFirst(pushed[p1]);
		p1++;

		while(p1 < pushed.length && p2 < popped.length) {
			if (stack.isEmpty()) {
				stack.addFirst(pushed[p1]);
				p1++;
			} else if (stack.peekFirst() != popped[p2]) {
				stack.addFirst(pushed[p1]);
				p1++;
			} else {
				stack.pollFirst();
				p2++;
			}
		}

		while(p2 < popped.length) {
			if (stack.peekFirst() != popped[p2]) {
				return false;
			}
			stack.pollFirst();
			p2++;
		}


		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.validateStackSequences(new int[]{0,2,1}, new int[]{0,1,2});
	}
}