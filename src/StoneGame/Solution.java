package StoneGame;
import java.util.*;

class Solution {
	public boolean stoneGame(int[] piles) {
		int sum = 0;
		for (int i = 0; i < piles.length;i++) {
			sum += piles[i];
		}
		int[][] dp = new int[piles.length][piles.length];

		int A = maximize(piles, 0, piles.length - 1, dp);

		int B = sum - A;

		return A > B;
	}

	int maximize(int[] piles, int left, int right, int[][] dp) {

		if (right <= left) {
			return 0;
		}

		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		int leftDecision = piles[left] + Math.min(maximize(piles, left + 2, right, dp), maximize(piles, left + 1, right - 1, dp));
		int rightDecision = piles[right] + Math.min(maximize(piles, left, right - 2, dp), maximize(piles, left + 1, right - 1, dp));
		int ans = Math.max(leftDecision, rightDecision);

		dp[left][right] = ans;

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.stoneGame(new int[]{5,3,4,5});
	}
}