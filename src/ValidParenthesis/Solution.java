package ValidParenthesis;

import java.util.*;


class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				}

				stack.pop();
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return false;
				}
				stack.pop();
			} else if (c == '}') {
				if (stack.isEmpty() || stack.peek() != '{') {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}

//public class Solution {
//    public static boolean isValid(String s) {
//        Deque<Character> stack = new ArrayDeque<>();
//
//        for (char c : s.toCharArray()) {
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//                continue;
//            }
//
//            if (stack.size() == 0) return false;
//            char openParen = stack.pop();
//
//            if (c == ')' && openParen != '(') return false;
//            if (c == '}' && openParen != '{') return false;
//            if (c == ']' && openParen != '[') return false;
//        }
//        if (stack.size() != 0) return false;
//        return true;
//    }
//
//
//    public static void main(String[] args) {
//        isValid("()");
//    }
//}
