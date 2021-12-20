package IntersectionOfTwoArray;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> firstSet = new HashSet<>();
		Set<Integer> secondSet = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			firstSet.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (firstSet.contains(nums2[i])) {
				secondSet.add(nums2[i]);
			}
		}
		int ptr = 0;

		int[] res = new int[secondSet.size()];

		for (int num : secondSet) {
			res[ptr] = num;
			ptr++;
		}

		return res;
	}
}