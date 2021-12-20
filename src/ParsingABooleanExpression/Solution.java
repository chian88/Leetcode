package ParsingABooleanExpression;
import java.util.*;

class Solution {
	public boolean parseBoolExpr(String expression) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ')') {
				StringBuilder expr = new StringBuilder();
				while (!stack.isEmpty() && stack.peekFirst() != '(') {
					expr.append(stack.pollFirst());
				}
				stack.pollFirst();
				Character operation = stack.pollFirst();
				if (operation == '|') {
					stack.addFirst(parseOr(expr.toString()));
				} else if (operation == '&') {
					stack.addFirst(parseAnd(expr.toString()));
				} else if (operation == '!') {
					stack.addFirst(parseNot(expr.toString()));
				}

			} else {
				stack.addFirst(expression.charAt(i));
			}
		}

		return stack.pollFirst() == 't' ? true : false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.parseBoolExpr("|(&(t,f,t),!(t))");
	}

	Character parseAnd(String s) {
		char ans = 't';
		String[] operands = s.split(",");

		for (String operand : operands) {
			if (operand.equals("f")) {
				ans = 'f';
			}
		}

		return ans;
	}

	Character parseNot(String s) {
		if (s.charAt(0) == 't') {
			return 'f';
		}

		return 't';
	}



	Character parseOr(String s) {
		char ans = 'f';
		String[] operands = s.split(",");

		for (String operand : operands) {
			if (operand.equals("t")) {
				ans = 't';
			}
		}

		return ans;
	}
}