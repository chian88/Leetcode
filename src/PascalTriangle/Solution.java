package PascalTriangle;
import java.util.*;

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			if (i == 0) {
				List<Integer> row = new ArrayList<>();
				row.add(1);
				res.add(row);
			} else if (i == 1) {
				List<Integer> row = new ArrayList<>();
				row.add(1);
				row.add(1);
				res.add(row);
			} else {
				List<Integer> row = new ArrayList<>();
				for (int col = 0; col <= i; col++) {

					if (col == 0 || col == i) {
						row.add(1);
					} else {
						int sum = res.get(i - 1).get(col - 1) + res.get(i - 1).get(col);
						row.add(sum);
					}
				}

				res.add(row);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.generate(5);
	}
}