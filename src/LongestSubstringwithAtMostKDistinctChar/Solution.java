package LongestSubstringwithAtMostKDistinctChar;
import java.util.*;

class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int start = 0;
		int end = 0;

		int max = Integer.MIN_VALUE;

		HashMap<Character, Integer> charCount = new HashMap<>();
		while (end < s.length()) {
			char c = s.charAt(end);
			end += 1;
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			} else {
				charCount.put(c, 1);
			}

			if (charCount.keySet().size() <= k) {
				max = Math.max(max, end - start);
			} else {
				while(charCount.keySet().size() > k) {
					char toDelete = s.charAt(start);
					start += 1;
					charCount.put(toDelete, charCount.get(toDelete) - 1);

					if (charCount.get(toDelete) == 0) {
						charCount.remove(toDelete);
					}
				}
				max = Math.max(max, end - start);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.lengthOfLongestSubstringKDistinct("eceba", 2);
	}
}