package RegularExpressionMatching;
import java.util.*;

class Solution {
	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) return text.isEmpty();
		boolean first_match = ( !text.isEmpty() &&
				(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
			// there is a star.

					// match after * because only zero or more
			return (isMatch(text, pattern.substring(2)) ||
					// first match, next char in text.
					(first_match && isMatch(text.substring(1), pattern)));
		} else {
					// first match && next next.
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		boolean tests =test.isMatch("bbc", ".*c");
		int x = 1;
	}
}