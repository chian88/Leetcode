package MinRemoveValidParen;
import java.util.*;


class Solution {
	public String minRemoveToMakeValid(String s) {
		Deque<int[]> parenStack = new ArrayDeque<>();
		// 1 for ( , 0 for )
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				parenStack.addFirst(new int[]{1, i});
			} else if (s.charAt(i) == ')') {
				if (parenStack.isEmpty()) {
					parenStack.addFirst(new int[]{0, i});
				} else if (parenStack.peekFirst()[0] == 1) {
					parenStack.pollFirst();
				} else {
					parenStack.addFirst(new int[]{0, i});
				}
			}
		}

		Set<Integer> banIdx = new HashSet<>();

		for (int[] item : parenStack) {
			banIdx.add(item[1]);
		}

		for (int j = 0; j < s.length(); j++) {
			if (!banIdx.contains(j)) {
				res.append(s.charAt(j));
			}
		}

		return res.toString();

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minRemoveToMakeValid("(a(b(c)d)");
	}
}

