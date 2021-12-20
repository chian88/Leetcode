package FirstDayWhereYouHaveBeeninAllRooms;
import java.util.*;

class Solution {
	public int firstDayBeenInAllRooms(int[] nextVisit) {
		int[] dp = new int[nextVisit.length + 1];
		dp[0] = 0;
		for (int i = 0; i < nextVisit.length - 1; i++) {
			dp[i + 1] = ((dp[i] + dp[i]) % 1000000007 - dp[nextVisit[i]] + 2) % 1000000007;
		}
		return (dp[nextVisit.length - 1] + 1000000007) % 1000000007;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.firstDayBeenInAllRooms(new int[]{0,0,2});
	}
}