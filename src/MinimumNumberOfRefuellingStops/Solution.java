package MinimumNumberOfRefuellingStops;
import java.util.*;


class Solution {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int N = stations.length;
		long[] dp = new long[N + 1];
		dp[0] = startFuel;
		for (int i = 0; i < N; ++i)
			for (int t = i; t >= 0; --t)
				if (dp[t] >= stations[i][0])
					dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

		for (int i = 0; i <= N; ++i)
			if (dp[i] >= target) return i;
		return -1;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.minRefuelStops(200, 50, new int[][] {{25,25}, {50, 100}, {100, 100}, {150,40}});
	}
}