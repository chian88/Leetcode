package CountPrime;
import java.util.*;
class Solution {
	public int countPrimes(int n) {
		boolean[] dp = new boolean[n];

		int count = 0;

		for (int candidate = 2; candidate < n; candidate++) {
			if (dp[candidate-1]) {
				continue;
			}

			if (checkPrime(candidate)){
				count++;
				markDp(candidate, dp);
			}
		}

		return count;
	}

	void markDp(int candidate, boolean[] dp) {
		int adder = candidate;
		while (candidate - 1 < dp.length ) {
			dp[candidate - 1] = true;
			candidate += adder;
		}

	}


	boolean checkPrime(int candidate) {

		for (int factor = 2; factor <= Math.sqrt(candidate); factor++) {
			if (candidate % factor == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countPrimes(10);
	}
}