package LargestDivisibleSubset;
import java.util.*;

class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {

		if (nums.length == 0) return new ArrayList<>();
		ArrayList<Integer>[] EDS = new ArrayList[nums.length];

		for (int i = 0; i < nums.length; i++) {
			EDS[i] = new ArrayList<>();
		}

		for (int i = 0; i < nums.length; i++) {

			List<Integer> maxSubSet = new ArrayList<>();
			for (int k = 0; k < i; k++) {
				if (nums[i] % nums[k] == 0 && maxSubSet.size() < EDS[k].size()) {
					maxSubSet = EDS[k];
				}
			}

			EDS[i].addAll(maxSubSet);
			EDS[i].add(nums[i]);
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (res.size() < EDS[i].size()) {
				res = EDS[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		 test.largestDivisibleSubset(new int[]{2,4,7,8});
	}
}