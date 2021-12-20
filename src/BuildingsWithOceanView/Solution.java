package BuildingsWithOceanView;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
	public int[] findBuildings(int[] heights) {
		int max = Integer.MIN_VALUE;
		List<Integer> res = new ArrayList<>();
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > max) {
				res.add(i);
				max = heights[i];
			}
		}

		int[] result = new int[res.size()];

		for (int i = res.size() - 1; i >= 0; i--) {
			result[res.size() - 1 - i] = res.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findBuildings(new int[]{4, 2, 3, 1});
	}
}



//class Solution {
//	public int[] findBuildings(int[] heights) {
//		Deque<Integer> stack = new ArrayDeque<>();
//
//		for (int i = 0; i < heights.length; i++) {
//			if (stack.isEmpty()) {
//				stack.addFirst(i);
//			} else {
//				while (!stack.isEmpty() &&
//						heights[stack.peekFirst()] <= heights[i]) {
//					stack.pollFirst();
//				}
//
//				stack.addFirst(i);
//			}
//		}
//
//		int[] res = new int[stack.size()];
//
//		int k = stack.size();
//
//		for (int i = 0; i < k; i++) {
//			res[i] = stack.pollLast();
//		}
//
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.findBuildings(new int[]{ 4,2,3,1});
//	}
//}