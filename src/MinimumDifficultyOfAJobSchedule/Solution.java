package MinimumDifficultyOfAJobSchedule;
import java.util.*;


class Solution {
	int d;
	int n;
	int[] jobDifficulty;
	public int minDifficulty(int[] jobDifficulty, int d) {
		this.jobDifficulty = jobDifficulty;
		this.d = d;
		this.n = jobDifficulty.length;
		if (d > jobDifficulty.length) {
			return -1;
		}


		Integer[][] dp = new Integer[n + 1][d + 1];
		int ans = recursion(0, 1, dp);

		return ans;
	}

	int recursion(int i, int day, Integer[][] dp) {
		if (day == d) {
			int hardest = jobDifficulty[i];
			for (int j = i; j < n ; j++) {
				hardest = Math.max(hardest, jobDifficulty[j]);
			}
			return hardest;
		}

		if (dp[i][day] != null) {
			return dp[i][day];
		}

		int ans = Integer.MAX_VALUE;
		int hardest = jobDifficulty[i];
		for (int j = i; j < n - (d - day); j++) {
			hardest = Math.max(hardest, jobDifficulty[j]);
			ans = Math.min(ans,  hardest + recursion(j + 1, day + 1, dp) );
		}
		dp[i][day] = ans;
		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minDifficulty(new int[]{6,5,4,3,2,1}, 2);
	}
}




//class Solution {
//	public int minDifficulty(int[] jobDifficulty, int d) {
//		int[][] dp = new int[jobDifficulty.length + 1][d + 1];
//		int ans = recursion(jobDifficulty, d, 0, 0, dp);
//		return ans;
//	}
//
//	int recursion(int[] jobDifficulty, int d, int currDay, int currJob, int[][] dp) {
//		if (currDay == d && currJob < jobDifficulty.length) {
//			return -1;
//		}
//
//		if (currDay < d && currJob == jobDifficulty.length) {
//			return -1;
//		}
//
//		if (currDay == d && currJob == jobDifficulty.length) {
//			return 0;
//		}
//
//		if (dp[currJob][currDay] > 0) {
//			return dp[currJob][currDay];
//		}
//
//
//		int jobDiff = Integer.MAX_VALUE;
//		int jobDiffSoFar = -1;
//		for (int i = currJob; i < jobDifficulty.length; i++) {
//			jobDiffSoFar = Math.max(jobDiffSoFar, jobDifficulty[i]);
//			int nextJobDiff = recursion(jobDifficulty, d, currDay + 1, i + 1, dp);
//			if (nextJobDiff != -1) {
//				jobDiff = Math.min(jobDiff, jobDiffSoFar + nextJobDiff);
//			}
//		}
//
//		jobDiff = jobDiff == Integer.MAX_VALUE ? -1 : jobDiff;
//
//		dp[currJob][currDay] = jobDiff;
//
//		return jobDiff;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6);
//	}
//}