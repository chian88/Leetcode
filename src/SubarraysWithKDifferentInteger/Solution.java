package SubarraysWithKDifferentInteger;
import java.util.*;


class Solution {
	public int subarraysWithKDistinct(int[] nums, int k) {
		return subarraysWithKDistinctHelper(nums, k) - subarraysWithKDistinctHelper(nums, k-1);
	}


	public int subarraysWithKDistinctHelper(int[] nums, int k) {
		if (k == 0) {
			return 0;
		}
		int total = 0;
		int diff = 0;
		int j = 0;
		int[] count = new int[40000];
		for (int i = 0; i < nums.length; i++) {
			if (count[nums[i]] == 0) {
				diff++;
				count[nums[i]]++;
			}  else {
				count[nums[i]]++;
			}

			if (diff <= k) {
				total += (i - j + 1);
			} else {
				while (j < nums.length && diff > k) {
					count[nums[j]]--;
					if (count[nums[j]] == 0) {
						diff--;
					}
					j++;
				}

				total += (i - j + 1);
			}
		}

		return total;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2);
	}
}