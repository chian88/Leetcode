package MaximumNestingDepthOfTheParenthesis;
import java.util.*;


class Solution {
	public int maxDepth(String s) {
		int currDepth = 0;
		int res = 0;


		for (char c : s.toCharArray()) {
			if (c == '(') {
				currDepth++;
				res = Math.max(res, currDepth);
			} else if (c == ')') {
				currDepth--;
			}
		}

		return res;
	}
}