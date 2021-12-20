package SubarraySumsDivisibleByK;
import java.util.*;

class Solution {
	public int subarraysDivByK(int[] nums, int k) {
		int[] prefixSum = new int[nums.length];

		prefixSum[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}

		Map<Integer, Integer> counter = new HashMap<>();

		for (int i = 0; i < prefixSum.length; i++) {
			int remainder = prefixSum[i] % k;

			if (remainder < 0) {
				remainder += k;
			}

			counter.put(remainder, counter.getOrDefault(remainder, 0) + 1);
		}

		int res = 0;

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			if (entry.getKey() == 0) {
				res += entry.getValue();
			}

			res += (entry.getValue() * (entry.getValue() - 1)) / 2;
		}

		return res;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
	}
}