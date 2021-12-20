package FirstNUniqueIntegersSumUpToZero;

import java.util.*;

class Solution {
	public int[] sumZero(int n) {
		if (n == 1) {
			return new int[] {0};
		}

		if (n == 2) {
			return new int[] {-1, 1};
		}

		int counter = 1;
		List<Integer> res = new ArrayList<>();
		if (n % 2 == 1) {
			while (n > 3) {
				res.add(counter);
				res.add(-counter);
				counter++;
				n -= 2;
			}

			res.add(counter);
			counter++;
			res.add(counter);
			res.add(-counter - counter + 1 );

			int[] ans = new int[res.size()];

			for (int i = 0; i < res.size(); i++) {
				ans[i] = res.get(i);
			}
			return ans;
		} else {
			while (n > 0) {
				res.add(counter);
				res.add(-counter);
				counter++;
				n -= 2;
			}
			int[] ans = new int[res.size()];

			for (int i = 0; i < res.size(); i++) {
				ans[i] = res.get(i);
			}
			return ans;
		}

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sumZero(5);
	}
}