package LongestSubstringWithoutRepeatingCharacters;
import java.util.*;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		int left = -1;
		int right = 0;
		int res = 1;
		Set<Character> seen = new HashSet<>();
		while (right < s.length()) {
			if (seen.contains(s.charAt(right))) {
				left++;
				seen.remove(s.charAt(left));
			} else {
				if (right < s.length()) {
					seen.add(s.charAt(right));
				}

				res = Math.max(res, right - left);
				right++;
			}
		}


		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.lengthOfLongestSubstring("pwwkew");
	}

}