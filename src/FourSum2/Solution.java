package FourSum2;
import java.util.*;


class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> cd = new HashMap<>();



		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				int sum = nums3[i] + nums4[j];
				cd.put(sum, cd.getOrDefault(sum, 0) + 1);
			}
		}

		int res = 0;

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int ab = nums1[i] + nums2[j];

				if (cd.containsKey(-ab)) {
					res += cd.get(-ab);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.fourSumCount(new int[]{-1,-1}, new int[]{-1,1}, new int[]{-1,1}, new int[]{1, -1});
	}
}
















//class Solution {
//	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//		Map<Integer, Integer> countAb = new HashMap<>();
//
//		for (int a : nums1) {
//			for (int b : nums2) {
//				countAb.put(a+b, countAb.getOrDefault(a + b, 0) + 1);
//			}
//		}
//
//		int res = 0;
//		for (int c : nums3) {
//			for (int d : nums4) {
//				int find = - (c + d);
//
//				if (countAb.containsKey(find)) {
//					res += countAb.get(find);
//				}
//			}
//		}
//
//		return res;
//	}
//}