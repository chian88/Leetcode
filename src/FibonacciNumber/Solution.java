package FibonacciNumber;

class Solution {
	public int fib(int n) {

		int[] dp = new int[n + 1];

		return fibHelper(n , dp);
	}

	public int fibHelper(int n, int[] dp) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (dp[n] != 0) return dp[n];

		int res = fibHelper(n - 1, dp) + fibHelper(n - 2, dp);

		dp[n] = res;

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int ans = test.fib(3);
	}


//	public int fib(int n) {
//
//		// this is bottom up.
//		if (n == 0) return 0;
//		if (n == 1) return 1;
//
//		int[] dp = new int[n + 1];
//
//		dp[0] = 0;
//		dp[1] = 1;
//
//		for (int i = 2; i < dp.length; i++) {
//			dp[i] = dp[i - 1] + dp[i - 2];
//		}
//
//		return dp[n];
//	}
}