package LongestRepeatingCharacterReplacement;
import java.util.*;

class Solution {
	public int characterReplacement(String s, int k) {
		int[] counter = new int[26];

		int left = 0;
		int right = 0;
		int res = 0;
		while (right < s.length()) {
			if (findNumOfReplacement(counter) <= k) {
				// increment right
				counter[s.charAt(right) - 'A']++;
				right++;

				if (findNumOfReplacement(counter) <= k) {
					res = Math.max(res, right - left);
				}


			} else {
				// increment left
				counter[s.charAt(left) - 'A']--;
				left++;

				if (findNumOfReplacement(counter) <= k) {
					res = Math.max(res, right - left);
				}
			}
		}

		return res;
	}

	int findNumOfReplacement(int[] counter) {
		int max = Integer.MIN_VALUE;
		int total = 0;
		for (int i = 0; i < counter.length; i++) {
			max = Math.max(max, counter[i]);
			total += counter[i];
		}

		if (max == Integer.MIN_VALUE) {
			return 0;
		}

		return total - max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.characterReplacement("AABABBA", 1);
	}
}