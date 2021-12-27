package MinRemoveToMakeValid;
import java.util.*;

class Solution {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> paren = new Stack<>();
		Set<Integer> toRemove = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				paren.add(i);
			} else if (c == ')' && !paren.isEmpty() && s.charAt(paren.peek()) == '(' ) {
				paren.pop();
			} else if (c == ')') {
				toRemove.add(i);
			}
		}

		while (!paren.isEmpty()) {
			toRemove.add(paren.pop());
		}

		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (!toRemove.contains(i)) {
				res.append(s.charAt(i));
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minRemoveToMakeValid("L(e)))et((co)d(e");
	}
}



//class Solution {
//	public static String minRemoveToMakeValid(String s) {
//		Deque<Character> parenthesis = new ArrayDeque<>();
//
//		StringBuilder res = new StringBuilder();
//
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//
//			if (c == ')') {
//				if (!parenthesis.isEmpty() && parenthesis.peekFirst() == '(') {
//					parenthesis.removeFirst();
//					res.append(c);
//				}
//			} else if (c == '(') {
//				parenthesis.addFirst(c);
//				res.append(c);
//			} else {
//				res.append(c);
//			}
//		}
//
//		parenthesis = new ArrayDeque<>();
//
//		s = res.toString();
//
//		for (int i = s.length() - 1; i >= 0; i--) {
//			char c = s.charAt(i);
//
//			if (c == '(' && (parenthesis.isEmpty() || parenthesis.peekFirst() == '(')) {
//				res.replace(i, i+1, "");
//			} else if (c == '(' && parenthesis.peekFirst() == ')') {
//				parenthesis.removeFirst();
//			} else if (c == ')') {
//				parenthesis.addFirst(c);
//			}
//		}
//
//		return res.toString();
//	}
//
//	public static void main(String[] args) {
//		minRemoveToMakeValid("(a(b(c)d)");
//	}
//}
//