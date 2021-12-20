package ConsecutiveNumberSum;
import java.util.*;


class Solution {
	public int consecutiveNumbersSum(int n) {
		if (n <= 1) return 1;

		int trial = (int) Math.ceil(n / 2.0);
		int res = 0;
		while (trial > 0) {
			if(gotConsecutiveSum(trial, n)) {
				res += 1;
			}

			trial -= 1;
		}


		return res + 1;
	}

	private boolean gotConsecutiveSum(int trial, int n) {
		int sum = trial;

		while (sum < n) {
			trial -= 1;
			sum += trial;
		}
		return sum == n;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.consecutiveNumbersSum(6);
	}
}