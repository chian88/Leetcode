package RangeAddition;
import java.util.*;

class Solution {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] prefixSum = new int[length + 1];

		for (int[] update : updates) {
			prefixSum[update[0]] = prefixSum[update[0]] + update[2];
			prefixSum[update[1] + 1] = prefixSum[update[1] + 1] - update[2];
		}

		for (int i = 1; i < length; i++) {
			prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
		}

		return prefixSum;
	}
}