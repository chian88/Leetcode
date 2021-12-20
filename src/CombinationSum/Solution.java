package CombinationSum;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<List<Integer>> res = new HashSet<>();

		for (int i = 0; i < candidates.length; i++) {
			List<Integer> intermediateRes = new ArrayList<>();
			intermediateRes.add(candidates[i]);
			combinationSumHelper(res , intermediateRes,
					target - candidates[i], candidates);
			intermediateRes.remove(intermediateRes.size() - 1);
		}
//
		return res.stream().collect(Collectors.toList());
	}

	void combinationSumHelper(Set<List<Integer>> res, List<Integer> intermediateRes, int remainingNum, int[] candidates) {
		if (remainingNum == 0) {
			List<Integer> sorted = new ArrayList<>(intermediateRes);
			Collections.sort(sorted);
			res.add(sorted);
			return;
		}


		for (int i = 0; i < candidates.length; i++) {
			if (remainingNum - candidates[i] < 0) continue;
			intermediateRes.add(candidates[i]);
			combinationSumHelper(res, intermediateRes, remainingNum - candidates[i], candidates);
			intermediateRes.remove(intermediateRes.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.combinationSum(new int[]{2,3,5}, 8);
	}
}