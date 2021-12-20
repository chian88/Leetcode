package ScoreOfParenthesis;
import java.util.*;

class Solution {
	public int scoreOfParentheses(String s) {
		int score = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		stack.addFirst(0);
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.addFirst(0);
			} else {
				int first = stack.pollFirst();
				int second = stack.pollFirst();

				stack.addFirst(second + Math.max(1, first * 2));
			}
		}

		return stack.pollFirst();
	}
}