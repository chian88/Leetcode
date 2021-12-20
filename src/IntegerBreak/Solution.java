package IntegerBreak;
import java.util.*;

class Solution {
	public int integerBreak(int n) {

		int[] dp = new int[n - 1];

		for (int i = 0; i < dp.length; i++) {
			if (i == 0) {
				dp[i] = breakIntoK(n, i + 2);
			} else {
				dp[i] = Math.max(dp[i - 1], breakIntoK(n, i + 2));
			}
		}

		return dp[n - 2];
	}

	public int breakIntoK(int n , int k) {
		int product = 1;

		while (n > 0) {
			int partial = (int) Math.ceil(n / k);
			n -= partial;
			k -= 1;
			product *= partial;
		}

		return product;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.integerBreak(11);
	}
}