package StoneGame2;
import java.util.*;


class Solution {
	public int stoneGameII(int[] piles) {
		int sum = 0;
		Integer[][] dp = new Integer[102][300];
		for (int pile : piles) {
			sum += pile;
		}

		int diff = recursion(piles, 1, 0, dp);
		return (sum + diff) / 2;

	}

	int recursion(int[] piles, int M, int idx, Integer[][] dp) {
		int max = Integer.MIN_VALUE;
		if (idx >= piles.length) {
			return 0;
		}

		if (dp[idx][M] != null) {
			return dp[idx][M];
		}

		int total = 0;
		for (int x = 0; x < 2 * M; x++) {
			if (idx + x < piles.length) {
				total += piles[x + idx];
			}

			max = Math.max(max, total - recursion(piles, Math.max(M, x + 1), idx + x + 1, dp));
		}

		dp[idx][M] = max;

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.stoneGameII(new int[]{2,7,9,4,4});
	}
}