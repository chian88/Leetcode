package LongestIncreasingSubsequence;
import java.util.*;


// dp + binary search

class Solution {
	public int lengthOFLIS(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; ++i) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				int j = binarySearch(sub, num);
				sub.set(j, num);
			}
		}

		return sub.size();
	}

	int binarySearch(ArrayList<Integer> sub, int num) {
		int left = 0;
		int right = sub.size() -1;
		int mid = (left + right) / 2;

		while (left < right) {
			mid = (left + right) / 2;
			if (sub.get(mid) == num) {
				return mid;
			}

			if (sub.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.lengthOFLIS(new int[]{10,9, 2, 5,3, 7});
	}
}

// dp
//class Solution {
//	public int lengthOfLIS(int[] nums) {
//		int[] dp = new int[nums.length];
//
//		Arrays.fill(dp, 1);
//		int max = 1;
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = 0; j < i; j++) {
//				if (nums[i] > nums[j]) {
//					dp[i] = Math.max(dp[i], dp[j] + 1);
//					max = Math.max(dp[i], max);
//				}
//			}
//		}
//
//		return max;
//	}
//}