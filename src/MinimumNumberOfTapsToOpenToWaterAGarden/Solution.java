package MinimumNumberOfTapsToOpenToWaterAGarden;
import java.util.*;


class Solution {
	public int minTaps(int n, int[] ranges) {
		int[][] intervals = new int[ranges.length][2];

		for (int i = 0; i < ranges.length; i++) {
			intervals[i] = new int[]{Math.max(0, i - ranges[i]), Math.min(ranges.length - 1, i + ranges[i])};
		}

		int[] dp = new int[ranges.length];

		for (int[] interval : intervals) {
			dp[interval[0]] = Math.max(dp[interval[0]], interval[1]);
		}

		int jumps = 0, farthest = 0, currentJumpEnd = 0;

		for (int i = 0; i < ranges.length - 1; i++) {
			farthest = Math.max(farthest, dp[i]);

			if (i == currentJumpEnd) {
				currentJumpEnd = farthest;
				jumps++;
			} else if (i > currentJumpEnd) {
				return -1;
			}
		}

		if (currentJumpEnd < ranges.length - 1) {
			return -1;
		}

		return jumps;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minTaps(5, new int[]{3, 0, 1,1, 0,0});
	}
}