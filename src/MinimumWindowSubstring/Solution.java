package MinimumWindowSubstring;
import java.util.*;
class Solution {
	public String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}

		if (t.length() == s.length()) {
			boolean found = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					found = false;
				}
			}

			if (found) {
				return s;
			}
		}

		Map<Character, Integer> tCount = new HashMap<>();
		Map<Character, Integer> sCount = new HashMap<>();

		for (char c : t.toCharArray()) {
			tCount.put(c, tCount.getOrDefault(c,0 ) + 1);
		}

		int start = 0;
		int end = 1;
		String res = "";
		int minLen = Integer.MAX_VALUE;

		sCount.put(s.charAt(0), 1);
		while (end <= s.length()) {
			if (enough(sCount, tCount)) {
				if ( (end - start) < minLen) {
					minLen = end - start;
					res = s.substring(start, end);
				}

				sCount.put(s.charAt(start), sCount.get(s.charAt(start)) - 1);
				start++;
			} else {
				end++;
				if(end <= s.length()) {
					sCount.put(s.charAt(end - 1), sCount.getOrDefault(s.charAt(end - 1), 0 ) + 1);
				}
			}
		}

		return res;
	}

	boolean enough(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
		for (Map.Entry<Character, Integer> tEntry : tCount.entrySet()) {
			if (sCount.getOrDefault(tEntry.getKey(), 0) < tEntry.getValue()) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minWindow("ab", "a");
	}
}