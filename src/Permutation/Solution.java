package Permutation;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permuteHelper(res, new ArrayList<>(), nums);

		return res;
	}


	public  void permuteHelper(List<List<Integer>> res, List<Integer> intermediate, int[] nums) {
		if (nums.length == 0) {
			res.add(new ArrayList<>(intermediate));
			intermediate.remove(intermediate.size() - 1);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			intermediate.add(nums[i]);
			int[] prev = Arrays.copyOfRange(nums, 0, i);
			int[] next = Arrays.copyOfRange(nums, i + 1, nums.length);

			int[] newArr = new int[prev.length + next.length];
			int ptr = 0;
			for (int j = 0; j < prev.length; j++) {
				newArr[ptr] = prev[j];
				ptr++;
			}

			for (int j = 0; j < next.length; j++) {
				newArr[ptr] = next[j];
				ptr++;
			}

			permuteHelper(res, intermediate, newArr);
		}

		if (intermediate.size() > 0) {
			intermediate.remove(intermediate.size() - 1);
		}

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.permute(new int[]{1,2,3});
	}
}