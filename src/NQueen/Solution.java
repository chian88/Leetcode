package NQueen;
import java.util.*;


class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();

		backtracking(0, n, res, new ArrayList<>());

		return res;
	}


	void backtracking(int row, int n, List<List<String>> res, List<String> curr) {
		if (row >= n) {
			res.add(new ArrayList<>(curr));
			return;
		}




		for (int col = 0; col < n; col++) {
			StringBuilder rows = generateFreshRow(n);
			rows.replace(col, col + 1, "Q");
			curr.add(rows.toString());

			if (isValid(curr)) {
				backtracking(row + 1, n, res, curr);
			}

			curr.remove(curr.size() - 1);
		}
	}

	boolean isValid(List<String> curr) {
		List<int[]> queenPositions = new ArrayList<>();

		for (int row = 0; row < curr.size(); row++) {
			for (int col = 0; col < curr.get(row).length(); col++) {
				if (curr.get(row).charAt(col) == 'Q') {
					queenPositions.add(new int[]{row, col});
				}

			}
		}


		for (int i = 0; i < queenPositions.size(); i++) {
			for (int j = i + 1; j < queenPositions.size(); j++) {
				int[] queenPosition1 = queenPositions.get(i);
				int[] queenPosition2 = queenPositions.get(j);

				if (queenPosition1[1] == queenPosition2[1]) {
					return false;
				}

				if (Math.abs(queenPosition1[0] - queenPosition2[0]) == Math.abs(queenPosition1[1] - queenPosition2[1])) {
					return false;
				}
			}
		}

		return true;
	}

	StringBuilder generateFreshRow(int n) {
		StringBuilder rows = new StringBuilder();
		for (int i = 0; i < n; i++) {
			rows.append('.');
		}

		return rows;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.solveNQueens(4);
	}
}