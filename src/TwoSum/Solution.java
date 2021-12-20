package TwoSum;

import java.util.*;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int toFind = target - nums[i];


			if (map.containsKey(toFind) && map.get(toFind) != i) {
				return new int[]{i, map.get(toFind)};
			}
		}

		return new int[]{};
	}
}




























//class Solution {
//	public int[] twoSum(int[] nums, int target) {
//		Map<Integer, Integer> numSet = new HashMap<>();
//
//		for (int i = 0; i < nums.length;i++) {
//			numSet.put(nums[i], i);
//		}
//
//		for (int i = 0; i < nums.length; i++) {
//			int remainder = target - nums[i];
//
//			if (numSet.containsKey(remainder) && i != numSet.get(remainder)) {
//				return new int[]{i, numSet.get(remainder)};
//			}
//		}
//
//		return new int[]{};
//	}
//
//    public static void main(String[] args) {
//		Solution test = new Solution();
//		test.twoSum(new int[]{3,2,4}, 6);
//    }
//}