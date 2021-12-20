package FrequencyOfTheMostFrequentElement;
import java.util.*;

class Solution {
	public int maxFrequency(int[] nums, int k) {
		int left = 0;
		int mod = 1000000007;
		int right = 0;
		long total = 0;
		long res = 0;
		Arrays.sort(nums);
		while (right < nums.length) {
			total += nums[right] % mod;
			while (nums[right] * (right - left + 1) > total + k) {
				total -= nums[left];
				left += 1;
			}

			res = Math.max(res, right - left + 1);
			right += 1;
		}

		return (int) res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxFrequency(new int[]{1,2,4}, 5);
	}
}