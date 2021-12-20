package MinimumSidewayJumps;
import java.util.*;

class Solution {
	int[] obstacles;
	int n;
	public int minSideJumps(int[] obstacles) {
		this.obstacles = obstacles;
		this.n = obstacles.length;
		Integer[][] dp = new Integer[n][4];
		int ans =	recursion(0, 2, dp);
		return ans;
	}

	int recursion(int i, int lane, Integer[][] dp) {

		if (i == n - 1) {
			return 0;
		}

		if (dp[i][lane] != null) {
			return dp[i][lane];
		}

		int res = Integer.MAX_VALUE;
		if (obstacles[i + 1] != lane) {
			// no obstacles; don't switch lane.
			res = recursion(i + 1, lane, dp);
		} else {

			for (int candidateLane = 1; candidateLane <= 3; candidateLane ++) {
				if (obstacles[i] == candidateLane || candidateLane == lane) {
					continue;
				}

				res = Math.min(res, recursion(i, candidateLane, dp) + 1);
			}

		}
		dp[i][lane] = res;
		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minSideJumps(new int[]{0,1,2,3,0});
	}
}