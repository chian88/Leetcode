package TwentyFourGame;
import java.util.*;

class Solution {
	private static final double EPSILON = 0.001;

	public boolean judgePoint24(int[] cards) {
		List<Double> nums = new ArrayList<>();
		for (int card : cards) {
			nums.add((double)card);
		}

		return recursion(nums);
	}

	boolean recursion(List<Double> cards) {
		if (cards.size() == 1) {
			return Math.abs(cards.get(0) - 24) <= EPSILON;
		}

		for (int i = 0; i < cards.size(); i++) {
			for (int j = 0; j < i; j++) {
				double num1 = cards.get(i);
				double num2 = cards.get(j);

				List<Double> values = new ArrayList<>();

				values.addAll(Arrays.asList(num1 + num2, num1 - num2, num2 - num1, num1 * num2, num1 / num2, num2 / num1));

				List<Double> copyNums = new ArrayList<>(cards);
				copyNums.remove(i);
				copyNums.remove(j);

				for (double value : values) {
					copyNums.add(value);
					if (recursion(copyNums)) {
						return true;
					}
					copyNums.remove(value);
				}
			}
		}

		return false;
	}
}