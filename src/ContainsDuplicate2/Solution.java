package ContainsDuplicate2;
import java.util.*;

class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> prevIdx = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (prevIdx.containsKey(nums[i])) {
				int dist = Math.abs(i - prevIdx.get(nums[i]));
				if (dist <= k) {
					return true;
				}
			}

			prevIdx.put(nums[i], i);
		}

		return false;
	}
}