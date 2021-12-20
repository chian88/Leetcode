package SingleNumber;
import java.util.*;
class Solution {
	public int singleNumber(int[] nums) {
		HashSet<Integer> seen = new HashSet<>();

		for (int num : nums) {
			if (!seen.contains(num)) {
				seen.add(num);
			} else {
				seen.remove(num);
			}
		}

		for (int num : seen) {
			return num;
		}

		return -1;
	}
}