package ValidParenthesisString;
import java.util.*;


class Solution {
	public boolean checkValidString(String s) {
		Stack<Character> stack = new Stack();
		//"()"
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				if (c == ')') {
					return false;
				}
				stack.add(c);
			} else {
				if (c == '(') {
					if (stack.peek() == ')') {
						return false;
					} else {
						stack.add(c);
					}
				} else if (c == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else if (stack.peek() == '*') {
						List<Character> temp = new ArrayList<>();

						while (!stack.isEmpty() && stack.peek() == '*') {
							temp.add(stack.pop());

						}

						if (stack.isEmpty()) {
							for(int i = 0; i < temp.size() - 1; i++) {
								stack.add(temp.get(i));
							}
						} else if (stack.peek() == '(') {
							stack.pop();
							for(int i = 0; i < temp.size(); i++) {
								stack.add(temp.get(i));
							}
						} else {
							return false;
						}


					} else {
						return false;
					}
				} else {
					stack.add(c);
				}
			}
		}

		if (stack.size() == 0) {
			return true;
		}

		//clear (
		Stack<Character> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			if(stack.peek() == '*') {
				tempStack.add(stack.pop());
			} else {
				if (tempStack.isEmpty()) {
					return false;
				} else {
					tempStack.pop();
					stack.pop();
				}
			}
		}

		for (Character c : tempStack) {
			if (c != '*') {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
	}
}