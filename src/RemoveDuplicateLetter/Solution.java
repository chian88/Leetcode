package RemoveDuplicateLetter;
import java.util.*;


class Solution {
	public String removeDuplicateLetters(String s) {
		int[] max = new int[26];

		for (int i = 0; i < s.length(); i++) {
			max[s.charAt(i) - 'a'] = i;
		}

		Deque<Character> stack = new ArrayDeque<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (set.contains(curr)) continue;
			if (stack.isEmpty()) {
				stack.addFirst(curr);
				set.add(curr);
			} else {
				char prev = stack.peekFirst();
				while (curr < prev && max[prev - 'a'] > i) {
					// do something
					stack.pollFirst();
					set.remove(prev);
					if (stack.isEmpty()) {
						break;
					}
					prev = stack.peekFirst();
				}
				stack.addFirst(curr);
				set.add(curr);

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
		test.removeDuplicateLetters("leetcode");
	}
}