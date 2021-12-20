package MinimumCostForTicket;
import java.util.*;


class Solution {
	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[days[days.length - 1] + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		Set<Integer> daySet = new HashSet<>();
		Map<Integer, Integer> dayMem = new HashMap<>();
		dayMem.put(0, 1);
		dayMem.put(1, 7);
		dayMem.put(2, 30);
		for (int day : days) {
			daySet.add(day);
		}

		for (int i = 1; i < dp.length; i++) {
			int day = i;

			if (daySet.contains(day)) {
				for (int j = 0; j < costs.length; j++) {
					dp[i] = Math.min(dp[ Math.max(i - dayMem.get(j), 0)] + costs[j], dp[i]);
				}
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15});
	}
}

