package CountNumberOfNiceSubarray;
import java.util.*;

class Solution {
	public int numberOfSubarrays(int[] nums, int k) {
		int[] prefixSum = new int[nums.length + 1];
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				runningSum++;
			}
			prefixSum[i + 1] = runningSum;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < prefixSum.length; i++) {
			map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);

			int remainder = prefixSum[i] - k;

			if (map.containsKey(remainder)) {
				res += map.get(remainder);
			}
		}

		return res;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
	}
}