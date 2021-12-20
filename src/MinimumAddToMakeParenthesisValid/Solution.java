package MinimumAddToMakeParenthesisValid;
import java.util.*;

class Solution {
	public int minAddToMakeValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.addFirst(c);
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == '(') {
					stack.pollFirst();
				} else {
					stack.addFirst(c);
				}
			}
		}

		return stack.size();
	}
}