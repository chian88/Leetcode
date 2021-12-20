package BasicCalculator2;
import java.util.*;

class Solution {
	public int calculate(String s) {
		List<String> operations = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int next = i + 1;
				StringBuilder operand = new StringBuilder();
				operand.append(c);
				while ( next < s.length() && Character.isDigit(s.charAt(next))) {
					operand.append(s.charAt(next));
					next++;
				}
				operations.add(operand.toString());
				i = next - 1;
			} else if (Character.isWhitespace(c)) {
				continue;
			} else {
				operations.add(String.valueOf(c));
			}


		}

		Deque<String> stack = new ArrayDeque<>();

		for (int i = 0; i < operations.size(); i++) {
			String oper = operations.get(i);

			if (oper.equals("+")) {
				stack.addFirst(oper);
			} else if (oper.equals("-")) {
				stack.addFirst(oper);
			} else if (oper.equals("*")) {
				String one = stack.pollFirst();
				String two = operations.get(++i);
				int res = Integer.parseInt(one) * Integer.parseInt(two);
				stack.addFirst(String.valueOf(res));
			} else if (oper.equals("/")) {
				String one = stack.pollFirst();
				String two = operations.get(++i);
				int res = Integer.parseInt(one) / Integer.parseInt(two);
				stack.addFirst(String.valueOf(res));
			} else {
				stack.addFirst(oper);
			}
		}

		while (stack.size() > 2) {
			String a = stack.pollLast();
			String oper = stack.pollLast();
			String b = stack.pollLast();

			if (oper.equals("+")) {
				int res = Integer.parseInt(a) + Integer.parseInt(b);
				stack.addLast(String.valueOf(res));
			} else if (oper.equals("-")) {
				int res = Integer.parseInt(a) - Integer.parseInt(b);
				stack.addLast(String.valueOf(res));
			}
		}


		return Integer.parseInt(stack.pollFirst());
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.calculate("1-1+1");
	}
}