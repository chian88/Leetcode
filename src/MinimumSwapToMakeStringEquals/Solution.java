package MinimumSwapToMakeStringEquals;
import java.util.*;

class Solution {
	public int minimumSwap(String s1, String s2) {
		int[] pattern = new int[2];

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
				pattern[0] += 1;
			} else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
				pattern[1] += 1;
			}

		}

		int res = 0;

		res += pattern[0] / 2;
		res += pattern[1] / 2;

		pattern[0] = pattern[0] % 2;
		pattern[1] = pattern[1] % 2 ;

		int totalDiffpairs = pattern[0] + pattern[1];

		if (totalDiffpairs % 2 == 1) {
			return -1;
		} else {
			res += totalDiffpairs;
			return res;
		}
	}
}