package RemoveDuplicateString;
import java.util.*;

class Solution {
	public String removeDuplicates(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.addFirst(c);
			} else if (stack.peekFirst() != c) {
				stack.addFirst(c);
			} else {
				stack.pollFirst();
			}
		}

		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pollLast());
		}

		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeDuplicates("abbaca");

	}
}