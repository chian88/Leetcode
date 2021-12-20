package RussianDollEnvelopes;
import java.util.*;

class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}

			dp[i] = num;;
			if (i == len) {
				len++;
			}


		}

		return len;
	}

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] == arr2[0]) {
					return arr2[1] - arr1[1];
				} else {
					return arr1[0] - arr2[0];
				}
			}
		});

		int[] secondDim = new int[envelopes.length];

		for (int i = 0; i < envelopes.length; i++) {
			secondDim[i] = envelopes[i][1];
		}

		return lengthOfLIS(secondDim);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxEnvelopes(new int[][]{{46,89}, {50,53}, {52,68}, {72,45}, {77,81}});
	}

}

//class Solution {
//	public int maxEnvelopes(int[][] envelopes) {
//		Arrays.sort(envelopes, new Comparator<int[]> () {
//			public int compare(int[] k1 , int[] k2) {
//				return k1[0] - k2[0];
//			}
//		});
//		Integer[] dp = new Integer[envelopes.length];
//		for (int i = 0; i < envelopes.length; i++) {
//			recursion(i, envelopes, dp);
//		}
//
//		int ans = 1;
//		for (int j = 0; j < dp.length; j++) {
//			ans = Math.max(ans, dp[j]);
//		}
//
//		return ans;
//	}
//
//	int recursion(int i, int[][] envelopes, Integer[] dp) {
//		if (i >= envelopes.length) {
//			return 0;
//		}
//
//		if (dp[i] != null) {
//			return dp[i];
//		}
//
//		int res = 1;
//		for (int j = i + 1; j < envelopes.length; j++) {
//			if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
//				res = Math.max(res, recursion(j, envelopes, dp) + 1);
//			}
//		}
//		dp[i] = res;
//		return res;
//	}
//
//
//}