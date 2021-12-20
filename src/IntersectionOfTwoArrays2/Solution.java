package IntersectionOfTwoArrays2;

import java.util.*;




class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			counter.put(nums2[i], counter.getOrDefault(nums2[i], 0) + 1);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			if (counter.containsKey(nums1[i]) && counter.get(nums1[i]) > 0) {
				res.add(nums1[i]);
				counter.put(nums1[i], counter.get(nums1[i]) - 1);
			}
		}

		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}

		return ans;
	}
}


























//class Solution {
//	public int[] intersect(int[] nums1, int[] nums2) {
//		int[] counter = new int[1001];
//
//		for (int i = 0; i < nums2.length; i++) {
//			counter[nums2[i]]++;
//		}
//		List<Integer> res = new ArrayList<>();
//		for (int i = 0; i < nums1.length; i++) {
//			if (counter[nums1[i]] > 0) {
//				res.add(nums1[i]);
//				counter[nums1[i]]--;
//			}
//		}
//
//		int[] result = new int[res.size()];
//
//		for (int i = 0 ; i < res.size(); i++) {
//			result[i] = res.get(i);
//		}
//
//		return result;
//	}
//}