package MaxCoins;
import java.util.*;

class Solution {
	public int maxCoins(int[] nums) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			numbers.add(nums[i]);
		}
		Map<List<Integer>, Integer> dp = new HashMap<>();
		int ans = recurse(numbers, dp);
		return ans;
	}

	int recurse(List<Integer> numbers, Map<List<Integer>, Integer> dp) {
		if (numbers.isEmpty()) return 0;

		if (dp.containsKey(numbers)) {
			return dp.get(numbers);
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.size(); i++) {
			int prev = 1;
			if (i - 1 >= 0) {
				prev = numbers.get(i - 1);
			}

			int next = 1;
			if (i + 1 < numbers.size()) {
				next = numbers.get(i + 1);
			}
			List<Integer> first = new ArrayList<>(numbers.subList(0, i));
			List<Integer> second = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
			first.addAll(second);
			int candidate = (prev * numbers.get(i) * next) + recurse(first, dp);
			ans = Math.max(ans, candidate);
		}
		dp.put(numbers, ans);
		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxCoins(new int[]{3,1,5,8});
	}
}