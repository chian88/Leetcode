package LastStoneWeight2;
import java.util.*;

class Solution {
	public int lastStoneWeightII(int[] stones) {
		int n = stones.length;
		int total = 0;
		for (int s : stones) {
			total += s;
		}

		boolean[] dp = new boolean[total / 2 + 1];

		dp[0] = true;

		int maxS2 = 0;

		for (int stone : stones) {
			boolean[] temp = dp.clone();
			for (int sum = stone ; sum <= total / 2; sum++) {
				if (dp[sum - stone]) {
					temp[sum] = true;
					maxS2 = Math.max(maxS2, sum);
					if (maxS2 == total/2) {
						return total - (maxS2 * 2);
					}
				}
			}

			dp = temp;
		}

		return total - (maxS2 * 2);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.lastStoneWeightII(new int[]{2,7,4,1,8,1});
	}
}