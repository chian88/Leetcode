package ReverseWordsInAString;
import java.util.*;

class Solution {
	public String reverseWords(String s) {
		String[] split = s.split("\\s+");

		StringBuilder sb = new StringBuilder();

		for (int i = split.length - 1; i >= 0; i--) {
			if (split[i].isEmpty()) {
				continue;
			}
			sb.append(split[i]);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.reverseWords("  hello world  ");
	}
}