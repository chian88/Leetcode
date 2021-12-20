package MinimumNumberOfOperationsToMoveAllBallsToEachBox;
import java.util.*;


class Solution {
	public int[] minOperations(String boxes) {
		int[] res = new int[boxes.length()];

		int[] left = new int[boxes.length()];
		int[] right = new int[boxes.length()];

		int count = 0;
		count = boxes.charAt(0) - '0';
		for (int i = 1; i < boxes.length(); i++) {
			left[i] = left[i - 1] + count;
			count += boxes.charAt(i) - '0';
		}

		count = 0;
		count = boxes.charAt(boxes.length() - 1) - '0';

		for (int i = boxes.length() - 2; i >= 0; i--) {
			right[i] = right[i + 1] + count;
			count += boxes.charAt(i) - '0';
		}

		for (int i = 0; i < boxes.length(); i++) {
			res[i] = left[i] + right[i];
		}

		return res;
	}
}