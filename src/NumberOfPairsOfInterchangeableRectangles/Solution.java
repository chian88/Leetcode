package NumberOfPairsOfInterchangeableRectangles;
import java.util.*;


class Solution {
	public long interchangeableRectangles(int[][] rectangles) {
		long res = 0;

		Map<Double, Long> ratioCounter = new HashMap<>();
		for (int i = 0; i < rectangles.length; i++) {
			int[] rectangleA = rectangles[i];

			double ratioA = rectangleA[0] * 1.0 / rectangleA[1];
			ratioCounter.put(ratioA, ratioCounter.getOrDefault(ratioA, 0L) + 1);
		}

		for (Map.Entry<Double, Long> ratioCount : ratioCounter.entrySet()) {
			res += ((ratioCount.getValue() - 1) * ratioCount.getValue()) / 2;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.interchangeableRectangles(new int[][] {{4,5}, {7,8}});
	}
}