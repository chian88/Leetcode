package NumberOfWaysToSplitAString;
import java.util.*;

class Solution {
	public int numWays(String s) {
		long totalOnes = 0;
		long MOD = 1_000_000_007;

		for (char c : s.toCharArray()) {
			if (c == '1') {
				totalOnes ++;
			}
		}

		if (totalOnes == 0) {
			long n = s.length() - 2;
			return (int) ((n * (n + 1) / 2) % MOD);
		}

		if (totalOnes % 3 != 0) {
			return 0;
		}


		long requiredOnes = totalOnes / 3;



		long left = 0;
		long right = 0;

		int OnesSoFar = 0;

		for (char c : s.toCharArray()) {
			if (c == '1') {
				OnesSoFar++;
			}

			if (c == '0' && OnesSoFar < (requiredOnes + 1) && OnesSoFar >= requiredOnes) {
				left = (left + 1) ;
			}

			if (c == '0' && OnesSoFar < (requiredOnes * 2 + 1) && OnesSoFar >= 2 * requiredOnes) {
				right = (right + 1);
			}


		}

		left = (left + 1) % MOD;
		right = (right + 1) % MOD;

		long ans = ((left) * (right)) % MOD ;

		return (int) ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
	}
}