package BasicCalculator;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public int calculate(String s) {
		Deque<String> stack = new ArrayDeque<>();

		char[] tokens = s.toCharArray();

		for (int i = 0; i < tokens.length; i++) {
			char c = tokens[i];
			if (Character.isWhitespace(c)) {
				continue;
			} else if (Character.isDigit(c)) {
				StringBuilder numStr = new StringBuilder();
				numStr.append(c);
				while (i + 1 < tokens.length &&
						Character.isDigit(tokens[i+1])) {
					i += 1;
					numStr.append(tokens[i]);
				}


				stack.addFirst(numStr.toString());

			} else if (c == ')') {
				int sum = evaluateUntilOpenParen(stack);

				stack.addFirst(String.valueOf(sum));
			} else {
				stack.addFirst(String.valueOf(c));
			}
		}

		int ans = evaluateUntilEnd(stack);

		return ans;
	}

	private int evaluateUntilEnd(Deque<String> stack) {
		int sum = 0;

		while(!stack.isEmpty()) {
			String token = stack.pollFirst();
			if (stack.isEmpty()) {
				sum += Integer.parseInt(token);
			} else if (stack.peekFirst().equals("-")) {
				sum -= Integer.parseInt(token);
			} else if (stack.peekFirst().equals("+")) {
				sum += Integer.parseInt(token);

			} else if (stack.peekFirst().equals("(")) {
				sum += Integer.parseInt(token);
			}
			stack.pollFirst();
		}
		return sum;

	}

	int evaluateUntilOpenParen(Deque<String> stack) {

		int sum = 0;

		while (!stack.peekFirst().equals("(")) {
			String token = stack.pollFirst();

			if (stack.peekFirst().equals("-")) {
				sum -= Integer.parseInt(token);
				stack.pollFirst();
			} else if (stack.peekFirst().equals("+")) {
				sum += Integer.parseInt(token);
				stack.pollFirst();
			} else if (stack.peekFirst().equals("(")) {
				sum += Integer.parseInt(token);
			}


		}
		stack.pollFirst();
		return sum;
	}



	public static void main(String[] args) {
		Solution test = new Solution();
		test.calculate(" (1+(42 +5 +2)-3)+(6+8)");
	}
}