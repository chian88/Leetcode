package MinimumAbsoluteDifferenceQueries;
import java.util.*;

class Solution {
	public int[] minDifference(int[] nums, int[][] queries) {
		int[][] prefixCount = new int[nums.length + 1][101];

		for (int i = 0; i < nums.length; i++) {
			prefixCount[i + 1] = prefixCount[i].clone();

			prefixCount[i + 1][nums[i]]++;
		}
		int[] ans = new int[queries.length];
		int ptr = 0;
		for (int[] query : queries) {
			int[] left = prefixCount[query[0]];
			int[] right = prefixCount[query[1] + 1];

			int[] temp = new int[left.length];
			for (int i = 0; i < left.length; i++) {
				temp[i] = right[i] - left[i];
			}
			int res = Integer.MAX_VALUE;
			for (int i = 0; i < temp.length; i++) {
				for (int j = i + 1; j < temp.length; j++) {
					if (temp[i] > 0 && temp[j] > 0) {
						res = Math.min(res, Math.abs(i - j));
					}
				}
			}
			ans[ptr] = res == Integer.MAX_VALUE ? -1 : res;
			ptr++;

		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minDifference(new int[]{1,3,4,8}, new int[][]{{0,1}, {1,2}, {2,3}, {0,3}});
	}
}