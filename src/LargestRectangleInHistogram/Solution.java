package LargestRectangleInHistogram;
import java.util.*;


class Solution {
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> pillarIndices = new ArrayDeque<>();

		int maxRectangle = 0;

		for (int i = 0; i <= heights.length; i++) {
			while (!pillarIndices.isEmpty() && isNewPillarOrReachEnd(heights, i, pillarIndices.peekFirst())) {
				int height = heights[pillarIndices.removeFirst()];
				int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peekFirst() - 1;

				maxRectangle = Math.max(maxRectangle, height * width);
			}

			pillarIndices.addFirst(i);
 		}

		return maxRectangle;
	}

	boolean isNewPillarOrReachEnd(int[] heights, int currIndx, int lastPillarIdx) {
		if (currIndx >= heights.length) {
			return true;
		}

		if (heights[currIndx] <= heights[lastPillarIdx]) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.largestRectangleArea(new int[]{1,4,2,5,6,3,2,6,6,5,2,1,3});
	}
}