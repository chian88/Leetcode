package RemoveInvalidParenthesis;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<String> removeInvalidParentheses(String s) {
		int[] misplacedParenthesis = findMisplacedParenthesis(s);
		Set<String> res = new HashSet<>();
		recursion(s, res, new StringBuilder(), misplacedParenthesis, new int[]{0, 0}, 0);
		return res.stream().collect(Collectors.toList());
	}

	void recursion(String s, Set<String> res , StringBuilder str, int[] misplacedParenthesis,
				   int[] currentReplacedParenthesis, int idx) {

		if (idx == s.length() && validStr(str.toString())) {
			res.add(str.toString());
			return;
		} else if (idx == s.length()) {
			return;
		}

		if (s.charAt(idx) == '(' && currentReplacedParenthesis[0] < misplacedParenthesis[0]) {
			currentReplacedParenthesis[0]++;
			recursion(s, res, str, misplacedParenthesis, currentReplacedParenthesis, idx+1);
			currentReplacedParenthesis[0]--;
		} else if (s.charAt(idx) == ')' && currentReplacedParenthesis[1] < misplacedParenthesis[1]) {
			currentReplacedParenthesis[1]++;
			recursion(s, res, str, misplacedParenthesis, currentReplacedParenthesis, idx+1);
			currentReplacedParenthesis[1]--;
		}


		str.append(s.charAt(idx));
		recursion(s, res, str, misplacedParenthesis, currentReplacedParenthesis, idx+1);
		str.deleteCharAt(str.length() - 1);


	}

	boolean validStr(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.addFirst('(');
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peekFirst() == '(') {
					stack.pollFirst();
				} else {
					return false;
				}
 			}
		}

		return stack.isEmpty();

	}

	int[] findMisplacedParenthesis(String s) {
		int left = 0;
		int right = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else if (s.charAt(i) == ')') {
				if (left > 0) {
					left--;
				} else {
					right++;
				}
			}
		}

		return new int[]{left, right};
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.removeInvalidParentheses("()())()");
	}
}

//class Solution {
//	public List<String> removeInvalidParentheses(String s) {
//		List<String> res = new ArrayList<>();
//		recursion(s, 0, res, new StringBuilder());
//	}
//
//	void recursion(String s, int idx, List<String> res, StringBuilder str) {
//		if (!validParen(str.toString())) {
//			return;
//		}
//
//		if (idx >= s.length()) {
//			res.add(str.toString());
//			return;
//		}
//
//		if (s.charAt(idx) == '(' || s.charAt(idx) == ')')  {
//			str.append(s.charAt(idx));
//			recursion(s, idx + 1, res, str);
//			str.deleteCharAt(str.length() - 1);
//			recursion(s, idx + 1, res, str);
//		} else {
//			str.append(s.charAt(idx));
//			recursion(s, idx + 1, res, str);
//		}
//	}
//
//	boolean validParen(String str) {
//		Deque<Character> stack = new ArrayDeque<>();
//
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) != ')') {
//
//			}
//		}
//	}
//}