package MinimizeDeletionCostToAvoidRepeatingLetters;
import java.util.*;

class Solution {
	public int minCost(String s, int[] cost) {
		int res = 0;

		for (int i = 0 ; i < s.length() - 1;i ++) {

			if (s.charAt(i) == s.charAt(i + 1) &&
					cost[i] <= cost[i + 1]) {
				res += cost[i];
			} else if (s.charAt(i) == s.charAt(i + 1)) {
				res += cost[i + 1];
				cost[i + 1] = cost[i];
			}
		}

		return res;
	}
}