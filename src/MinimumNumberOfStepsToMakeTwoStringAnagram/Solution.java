package MinimumNumberOfStepsToMakeTwoStringAnagram;
import java.util.*;

class Solution {
	public int minSteps(String s, String t) {
		int[] countS = new int[26];
		int[] countT = new int[26];

		for (int i = 0; i < s.length(); i++) {
			countS[s.charAt(i) - 'a']++;
			countT[t.charAt(i) - 'a']++;
		}
		int res = 0;
		for (int i = 0 ; i < countS.length; i++) {
			if (countS[i] > countT[i]) {
				res += Math.abs(countS[i] - countT[i]);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minSteps("anagram", "mangaar");
	}
}