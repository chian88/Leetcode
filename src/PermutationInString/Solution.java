package PermutationInString;
import java.util.*;

class Solution {
	public boolean checkInclusion(String s1, String s2) {
		int[] counter1 = new int[26];
		int[] counter2 = new int[26];
		countChar(s1, counter1);

		int right = 0;
		int left = -1;
		counter2[s2.charAt(right) - 'a']++;
		while (right < s2.length()) {

			int toggle = matchCounter(counter1, counter2);
			if (toggle == 1) {
				right++;
				if (right < s2.length()) {
					counter2[s2.charAt(right) - 'a']++;
				}

			} else if (toggle == -1) {
				left++;
				counter2[s2.charAt(left) - 'a']--;
			} else {
				return true;
			}
		}
		int toggle = matchCounter(counter1, counter2);

		if (toggle == 0) {
			return true;
		}

		return false;
	}


	int matchCounter(int[] counter1, int[] counter2) {
		int count2 = 0;
		int count1 = 0;
		for (int i = 0 ; i < 26; i++) {
			if (counter2[i] > counter1[i]) {
				return -1;
			}

			if (counter1[i] > 0) {
				count1 += counter1[i];
			}
			if (counter2[i] > 0) {
				count2 += counter2[i];
			}
		}

		if (count1 == count2) {
			return 0;
		}

		return 1;
	}

	void countChar(String str, int[] counter) {
		for (char c : str.toCharArray()) {
			counter[c - 'a']++;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.checkInclusion("hello", "ooolleoooleh");
	}
}