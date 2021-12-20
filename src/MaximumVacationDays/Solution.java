package MaximumVacationDays;
import java.util.*;

class Solution {
	int[][] flights;
	int[][] days;

	public int maxVacationDays(int[][] flights, int[][] days) {
		this.flights = flights;
		this.days = days;
		Integer[][] dp = new Integer[flights.length][days[0].length];
		int nas=  recursion(0, 0, dp);
		return nas;
	}

	int recursion(int week, int currentCity, Integer[][] dp) {
		if (week >= days[0].length) {
			return 0;
		}
		if (dp[currentCity][week] != null) {
			return dp[currentCity][week];
		}

		int max = Integer.MIN_VALUE;
		for (int toCity = 0; toCity < flights.length; toCity++) {
			if (toCity == currentCity) {
				max = Math.max(max, days[currentCity][week] + recursion(week + 1, currentCity, dp));
			} else if (flights[currentCity][toCity] == 1) {
				max = Math.max(max, days[toCity][week] + recursion(week + 1, toCity, dp));
			}
		}

		dp[currentCity][week] = max;

		return max;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxVacationDays(new int[][]{{0,1,1}, {1,0,1}, {1,1,0}}, new int[][]{{1,3,1}, {6,0,3}, {3,3,3}});
	}
}