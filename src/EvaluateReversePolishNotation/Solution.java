package EvaluateReversePolishNotation;
import java.util.*;

class Solution {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack();

		for (String token : tokens) {
			if (token.equals("+")) {
				String second = stack.pop();
				String first = stack.pop();
				int res = Integer.parseInt(first) + Integer.parseInt(second);
				stack.push(String.valueOf(res));
			} else if (token.equals("-")) {
				String second = stack.pop();
				String first = stack.pop();
				int res = Integer.parseInt(first) - Integer.parseInt(second);
				stack.push(String.valueOf(res));
			} else if (token.equals("*")) {
				String second = stack.pop();
				String first = stack.pop();
				int res = Integer.parseInt(first) * Integer.parseInt(second);
				stack.push(String.valueOf(res));
			} else if (token.equals("/")) {
				String second = stack.pop();
				String first = stack.pop();
				int res = Integer.parseInt(first) / Integer.parseInt(second);
				stack.push(String.valueOf(res));
			} else {
				stack.push(token);
			}
		}

		return Integer.parseInt(stack.pop());
	}
}