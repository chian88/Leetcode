package NumberOfGoodPairs;
import java.util.*;

class Solution {
	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
		}

		int res = 0;

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			res += (entry.getValue() * (entry.getValue() - 1)) / 2;
		}
		return res;

	}
}