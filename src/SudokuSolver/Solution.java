package SudokuSolver;
import java.util.*;

class Solution {
	public void solveSudoku(char[][] board) {

		backtracking(board, 0, 0);
		int ans = 1;
	}


	boolean backtracking(char[][] board, int row, int col) {
		if (row >= board.length) {
			return true;
		}

		if (board[row][col] != '.') {
			col++;

			if (col >= board[0].length) {
				col = 0;
				row++;
			}

			if (backtracking(board, row, col)) {
				return true;
			}

			return false;
		}

		for (int candidate = 1; candidate <= 9; candidate++) {
			board[row][col] = (char) (candidate + '0');

			if(isValidSudoku(board)) {
				int newCol = col + 1;
				int newRow = row;
				if (newCol >= board[0].length) {
					newCol = 0;
					newRow++;
				}

				if (backtracking(board, newRow, newCol)) {
					return true;
				}


			}
		}
		board[row][col] = '.';
		return false;
	}

	boolean isValidSudoku(char[][] board) {
		if(!isValidRow(board)) {
			return false;
		}

		if (!isValidCol(board)) {
			return false;
		}

		if (!isValidSquare(board)) {
			return false;
		}

		return true;
	}

	boolean isValidSquare(char[][] board) {
		int colOffset = 0;
		int rowOffset = 0;

		while (rowOffset < board.length) {
			Set<Character> seen = new HashSet<>();
			for (int row = rowOffset; row < rowOffset + 3; row++) {
				for (int col = colOffset; col < colOffset + 3; col++) {
					if (board[row][col] == '.') {
						continue;
					}

					if (seen.contains(board[row][col])) {
						return false;
					}

					seen.add(board[row][col]);
				}
			}

			colOffset += 3;
			if (colOffset >= board[0].length) {
				colOffset = 0;
				rowOffset += 3;
			}
		}
		return true;
	}

	boolean isValidCol(char[][] board) {


		for (int col = 0; col < board.length; col++) {
			Set<Character> seen = new HashSet<>();
			for (int row = 0; row < board[col].length; row++) {
				if (board[row][col] == '.')  {
					continue;
				}
				if (seen.contains(board[row][col])) {
					return false;
				}

				seen.add(board[row][col]);
			}
		}

		return true;
	}

	boolean isValidRow(char[][] board) {


		for (int row = 0; row < board.length; row++) {
			Set<Character> seen = new HashSet<>();
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == '.') {
					continue;
				}
				if (seen.contains(board[row][col])) {
					return false;
				}

				seen.add(board[row][col]);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		test.solveSudoku(board);
	}
}