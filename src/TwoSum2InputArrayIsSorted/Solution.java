package TwoSum2InputArrayIsSorted;
import java.util.*;

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap();

		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			int toFind = target - numbers[i];

			if (map.containsKey(toFind) && map.get(toFind) != i ) {
				int[] ans = new int[]{i + 1, map.get(toFind) + 1};
				Arrays.sort(ans);
				return ans;
			}
		}

		return new int[]{};
	}


}