package DecodeString;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
	public String decodeString(String s) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				stack.add(sb.toString());
			} else if (s.charAt(i) == '[') {
				stack.add("[");
			} else if (Character.isLetter(s.charAt(i))){
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && Character.isLetter(s.charAt(i))) {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				stack.add(sb.toString());
			} else {
				StringBuilder content2 = new StringBuilder();
				while (stack.peek() != "[") {
					content2.insert(0, stack.pop());
				}
				stack.pop();
				String num = stack.pop();
				String content = content2.toString();
				stack.add(content.repeat(Integer.parseInt(num)));
			}
		}
		StringBuilder res = new StringBuilder();

		while (!stack.isEmpty()) {
			res.insert(0, stack.pop());
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.decodeString("3[a2[c]]");
	}
}


//class Solution {
//    public String decodeString(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            if (c == ']') {
//                StringBuilder partialStr = new StringBuilder();
//
//                while (stack.peek() != '[') {
//                    partialStr.insert(0, stack.pop());
//                }
//
//                stack.pop();
//
//                int k = 0;
//                int base = 1;
//
//                while(stack.size() > 0 && Character.isDigit(stack.peek())) {
//                    k = k + (stack.pop() - '0') * base;
//                    base *= 10;
//                }
//
//                while ( k > 0) {
//                    for (int i = 0; i < partialStr.length(); i++) {
//                        char chr = partialStr.charAt(i);
//                        stack.push(chr);
//                    }
//
//                    k--;
//                }
//
//            } else {
//                stack.push(c);
//            }
//        }
//        char[] chars = new char[stack.size()];
//
//        for (int i = stack.size() - 1; i >= 0; i --) {
//            chars[i] = stack.pop();
//        }
//
//        return new String(chars);
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//        StringBuilder word = new StringBuilder();
//
//
//
//        String result = test.decodeString("abc3[cd]xyz");
//    }
//}
