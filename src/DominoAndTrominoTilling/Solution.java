package DominoAndTrominoTilling;
import java.util.*;


class Solution {
	public int numTilings(int n) {
		int[][] dp = new int[n][n];

		int count = recurse(n, n, dp);

		return count;
	}

	int recurse(int top, int down, int[][] dp) {
		int count = 0;

		if (top < 0 || down < 0) {
			return 0;
		}

		if (top == 1 && down == 1) {
			return 1;
		}

		if (top == 2 && down == 1) {
			return 1;
		}

		if (down == 2 && top == 1) {
			return 1;
		}

		if (top == 2 && down == 0) {
			return 1;
		}

		if (top == 0 && down == 2) {
			return 1;
		}

		// vertical
		count += recurse(top - 1, down - 1, dp);

		// horizontal - top
		count += Math.max(recurse(top - 2, down, dp), recurse(top, down - 2, dp));

		// L - top
		count += recurse(top - 2, down -1, dp);

		// L - down
		count += recurse(top - 1, down -2, dp);

		return count;
	}

	public static void main(String[] args) {

		Solution test = new Solution();
		test.numTilings(3);
	}
}