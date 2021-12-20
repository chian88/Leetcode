package SortIntegersByThePowerValue;
import java.util.*;

class Solution {
	public int getKth(int lo, int hi, int k) {
		int[][] arr = new int[hi - lo + 1][2];
		int ptr = 0;
		Map<Integer, Integer> dp = new HashMap<>();
		for (int num = lo; num <= hi; num++) {
			arr[ptr][0] = generatePower(num, dp);
			arr[ptr][1] = num;
			ptr++;
		}

		Arrays.sort(arr, (a, b) -> {
			int powerCmp = Integer.compare(a[0], b[0]);
			if (powerCmp != 0) {
				return powerCmp;
			}

			return Integer.compare(a[1], b[1]);
		});

		return arr[k - 1][1];
	}

	int generatePower(int num, Map<Integer, Integer> dp) {
		if (num == 1) {
			return 0;
		}

		if (dp.containsKey(num)) {
			return dp.get(num);
		}

		if (num % 2 == 0) {
			int step = generatePower(num / 2, dp) + 1;
			dp.put(num, step);
			return step;
		} else {
			int step = generatePower(3 * num + 1, dp) + 1;
			dp.put(num, step);
			return step;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.getKth(12,15,2);
		test.generatePower(5, new HashMap<>());
	}
}