package MaxAreaRectangle;
import java.util.*;


class Solution {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		int prevHorizontal = 0;
		long maxHorizontal = Long.MIN_VALUE;
		Arrays.sort(horizontalCuts);
		for (int i = 0; i < horizontalCuts.length; i++) {
			maxHorizontal = Math.max(maxHorizontal, horizontalCuts[i] - prevHorizontal);
			prevHorizontal = horizontalCuts[i];
		}
		maxHorizontal = Math.max(maxHorizontal, h - horizontalCuts[horizontalCuts.length - 1]);

		int prevVertical = 0;
		long maxVertical = Long.MIN_VALUE;
		Arrays.sort(verticalCuts);
		for (int i = 0; i < verticalCuts.length; i++) {
			maxVertical = Math.max(maxVertical, verticalCuts[i] - prevVertical);
			prevVertical = verticalCuts[i];
		}
		maxVertical = Math.max(maxVertical, w - verticalCuts[verticalCuts.length - 1]);

		int area = (int) ((maxHorizontal * maxVertical) % 1000000007);
		return area;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxArea(1000000000,1000000000, new int[]{2}, new int[]{2});
	}
}