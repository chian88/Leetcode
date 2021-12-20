package NextGreaterElement1;
import java.util.*;


class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Deque<Integer> stack = new ArrayDeque<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
				map.put(stack.pollFirst(), nums2[i]);
			}
			stack.addFirst(nums2[i]);


 		}

		while (!stack.isEmpty()) {
			map.put(stack.pollFirst(), -1);
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}

		return res;
	}
}