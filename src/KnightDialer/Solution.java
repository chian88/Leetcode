package KnightDialer;
import java.util.*;


class Solution {

	public static int knightDialer(int n) {
		Map<Integer, int[]> numPad = new HashMap<>();
		numPad.put(1, new int[]{6,8});
		numPad.put(2, new int[]{7,9});
		numPad.put(3, new int[]{8, 4});
		numPad.put(4, new int[]{3,9,0});
		numPad.put(5, new int[]{});
		numPad.put(6, new int[]{1,7,0});
		numPad.put(7, new int[]{2,6});
		numPad.put(8, new int[]{1,3});
		numPad.put(9, new int[]{2,4});
		numPad.put(0, new int[]{4,6});

		long[][] dp = new long[n][10];
		int Mod = (int) Math.pow(10,9) + 7;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0) {
					dp[i][j] = 1;
				} else {
					int[] cameFroms = numPad.get(j);
					int count = 0;
					for (int cameFrom : cameFroms) {
						dp[i][j] += dp[i - 1][cameFrom];
					}
					dp[i][j] = dp[i][j] % Mod;
				}
			}
		}

		long res = 0;

		for (int j = 0; j < 10; j++) {
			res += dp[n-1][j];
		}
		res = (res % Mod);

		int realResult = (int) res;
		return realResult ;
	}

//	public static int knightDialerHelper(int n, Map<Integer, int[]> numPad, int num, int[][] dp) {
//		if (n == 0) {
//			dp[n][num] = 0;
//			return 0;
//		}
//
//		if (n == 1) {
//			dp[n][num] = 1;
//			return 1;
//		}
//
//		if (dp[n][num] != 0) return dp[n][num];
//
//		int[] childNums = numPad.get(num);
//		int count = 0;
//		for (int childNum : childNums) {
//			count += knightDialerHelper(n - 1, numPad, childNum, dp) ;
//		}
//		dp[n][num] = count;
//
//		return count;
//	}

	public static void main(String[] args) {
		int count = knightDialer(3131);
		int x = 1;
	}
}