package NumberOfGoodWaysToSplitString;

import java.util.*;

class Solution {
	public int numSplits(String s) {
		Map<Character, Integer> rightCounter = new HashMap<>();

		for (char c : s.toCharArray()) {
			rightCounter.put(c, rightCounter.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> leftCounter = new HashMap<>();
		int res = 0;
		for (char c : s.toCharArray()) {
			leftCounter.put(c, leftCounter.getOrDefault(c, 0) + 1);

			rightCounter.put(c, rightCounter.get(c) - 1);

			if (rightCounter.get(c) == 0) {
				rightCounter.remove(c);
			}

			if (leftCounter.size() == rightCounter.size()) {
				res += 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numSplits("aacaba");
	}
}