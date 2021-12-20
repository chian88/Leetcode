package FlipStringToMonotoneIncreasing;
import java.util.*;

class Solution {
	public int minFlipsMonoIncr(String s) {
		int N = s.length();
		int[] prefixSum = new int[N + 1];

		int currNumOfOnes = 0;
		prefixSum[0] = currNumOfOnes;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				currNumOfOnes += 1;
			}
			prefixSum[i + 1] = currNumOfOnes;
		}
		int min = Integer.MAX_VALUE;
		for (int x = 0; x < prefixSum.length; x++) {
			int candidate = prefixSum[x] +  ((N - x) - (prefixSum[prefixSum.length - 1] - prefixSum[x]));
			min = Math.min(min, candidate);
		}

		return min;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minFlipsMonoIncr("010110");
	}
}