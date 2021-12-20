package Subsets2;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> numsList = new ArrayList<>();
		for (int num : nums) {
			numsList.add(num);
		}
		recursion(res, numsList);

		return res.stream().collect(Collectors.toList());
	}

	void recursion(Set<List<Integer>> res, List<Integer> numsList){
		for (int i = 0; i < numsList.size(); i++) {
			List<Integer> newNumsList = new ArrayList<>(numsList);
			newNumsList.remove(i);
			Collections.sort(newNumsList);
			if (!res.contains(newNumsList)) {
				recursion(res, newNumsList);
			}

		}

		res.add(numsList);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.subsetsWithDup(new int[]{4,4,4,1,4});
	}
}