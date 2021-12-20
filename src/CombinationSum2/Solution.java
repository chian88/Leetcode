package CombinationSum2;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> res = new HashSet<>();
		Integer[] candidates2 = Arrays.stream(candidates).boxed().toArray(Integer[]::new);
		Arrays.sort(candidates2, Collections.reverseOrder());
		recursion(candidates2, target, 0,  0, new ArrayList<>(), res);
		return res.stream().collect(Collectors.toList());
	}

	void recursion(Integer[] candidates, int target, int idx, int curr, List<Integer> temp, Set<List<Integer>> res) {
		if (curr > target) {
			return;
		}

		if (curr == target) {
			List<Integer> temp2 = new ArrayList<>(temp);
			Collections.sort(temp2);
			res.add(temp2);
		}

		for (int i = idx; i < candidates.length; i++) {
			curr += candidates[i];
			temp.add(candidates[i]);
			recursion(candidates, target, i + 1, curr, temp, res);
			temp.remove(temp.size() - 1);
			curr -= candidates[i];
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
	}
}