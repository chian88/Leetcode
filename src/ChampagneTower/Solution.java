package ChampagneTower;
import java.util.*;

class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[] prev = null;
		int count = 0;
		int size = 1;

		if (query_row == 0) {
			return poured > 1 ? 1 : poured;
		}


		while (count < query_row) {

			if (prev == null) {
				prev = new double[size++];
				prev[0] = Math.max(0, poured - 1.0);
			} else {
				double[] curr = new double[size++];
				for (int i = 0; i < curr.length; i++) {
					if (i == 0) {
						curr[i] = Math.max(0, prev[i] / 2.0 - 1.0);
					} else if (i == curr.length - 1) {
						curr[i] = Math.max(0, prev[i - 1] / 2.0 - 1.0);
					} else {
						curr[i] = Math.max(0, (prev[i - 1] / 2.0) + (prev[i] / 2.0) - 1.0);
					}
				}
				prev = curr;
			}
			count++;
		}

		double[] curr = new double[size++];
		for (int i = 0; i < curr.length; i++) {
			if (i == 0) {
				curr[i] = Math.max(0, prev[i] / 2.0);
			} else if (i == curr.length - 1) {
				curr[i] = Math.max(0, prev[i - 1] / 2.0);
			} else {
				curr[i] = Math.max(0, (prev[i - 1] / 2.0) + (prev[i] / 2.0));
			}
		}

		return curr[query_glass] > 1 ? 1 : curr[query_glass];

	}

	public static void main(String[] args) {
		Solution test =  new Solution();
		test.champagneTower(0, 0, 0);
	}
}

