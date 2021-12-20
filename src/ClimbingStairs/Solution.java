package ClimbingStairs;
import java.util.*;

class Solution {
	public int climbStairs(int n) {
		int[] dp = new int[n];

		Arrays.fill(dp, -1);
		return climbStairsHelper(n, dp);
	}

	public int climbStairsHelper(int n, int[] dp) {
		if (n == 1) {
			dp[n - 1] = 1;
			return 1;
		}

		if (n == 2) {
			dp[n - 1] = 2;
			return 2;
		}

		if (dp[n - 1] != -1) return dp[n -1];

		int ways= climbStairsHelper(n - 2, dp) + climbStairsHelper( n - 1, dp);

		dp[n - 1] = ways;

		return ways;


	}

    public static void main(String[] args) {
		Solution test = new Solution();
		test.climbStairs(4);
    }
}