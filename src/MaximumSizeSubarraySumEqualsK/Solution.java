package MaximumSizeSubarraySumEqualsK;
import java.util.*;

class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		int[] prefixSum = new int[nums.length];
		int running = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < prefixSum.length; i++) {
			running += nums[i];
			prefixSum[i] = running;
		}
		int res = 0;
		map.put(0, -1);
		for (int i = 0; i < prefixSum.length; i++) {
			int toFind = prefixSum[i] - k;
			if (map.containsKey(toFind)) {
				res = Math.max(res, i - map.get(toFind));
			}

			if (!map.containsKey(prefixSum[i])) {
				map.put(prefixSum[i], i);
			}




		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
	}
}