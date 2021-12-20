package ValidSudoku;
import java.util.*;


class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean rowValid = checkRow(board);
		if (!rowValid) {
			return false;
		}

		boolean colValid = checkCol(board);
		if (!colValid) {
			return false;
		}

		boolean squareValid = checkSquare(board);

		if (!squareValid) {
			return false;
		}

		return true;
	}

	boolean checkSquare(char[][] board) {
		int rowOffset = 0;
		int colOffset = 0;

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

	boolean checkRow(char[][] board) {


		for (int row = 0; row < board.length; row++) {
			Set<Character> seen = new HashSet<>();
			for (int col = 0; col < board[0].length; col++) {
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

	boolean checkCol(char[][] board) {
		for (int col = 0; col < board[0].length; col++) {
			Set<Character> seen = new HashSet<>();
			for (int row = 0; row < board.length; row++) {
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
		test.isValidSudoku(new char[][]{{'.','.','.','.','.','.','5','.','.'},
				                        {'.','.','.','.','.','.','.','.','.'},
				                        {'.','.','.','.','.','.','.','.','.'},
				                        {'9','3','.','.','2','.','4','.','.'},
				                        {'.','.','7','.','.','.','3','.','.'},
				                        {'.','.','.','.','.','.','.','.','.'},
				                        {'.','.','.','3','4','.','.','.','.'},
				                        {'.','.','.','.','.','3','.','.','.'},
				                        {'.','.','.','.','.','5','2','.','.'}});
	}
}
























//class Solution {
//	public boolean isValidSudoku(char[][] board) {
//		if (!rowCheck(board)) {
//			return false;
//		}
//		if (!colCheck(board)) {
//			return false;
//		}
//		if(!squareCheck(board)) {
//			return false;
//		}
//
//		return true;
//	}
//
//	boolean squareCheck(char[][] board) {
//		int rowOffset = 0;
//		int colOffset = 0;
//
//		while(rowOffset != board.length) {
//			Set<Character> squareNum = new HashSet<>();
//			for (int i = rowOffset; i < rowOffset + 3; i++) {
//				for (int j = colOffset; j < colOffset + 3; j++) {
//					if (Character.isDigit(board[i][j]) && squareNum.contains(board[i][j])) {
//						return false;
//					} else {
//						squareNum.add(board[i][j]);
//					}
//				}
//
//
//			}
//			colOffset += 3;
//
//			if (colOffset == board[0].length) {
//				colOffset = 0;
//				rowOffset += 3;
//			}
//
//		}
//
//		return true;
//
//	}
//
//
//	boolean colCheck(char[][] board) {
//		for (int j = 0; j < board[0].length; j++) {
//			Set<Character> colNum = new HashSet<>();
//			for (int i = 0; i < board.length; i++) {
//				if (Character.isDigit(board[i][j]) && colNum.contains(board[i][j])) {
//					return false;
//				} else {
//					colNum.add(board[i][j]);
//				}
//			}
//		}
//
//		return true;
//	}
//
//	boolean rowCheck(char[][] board) {
//		for (int i = 0; i < board.length; i++) {
//			Set<Character> rowNum = new HashSet<>();
//			for (int j = 0; j < board[i].length; j++) {
//				if (Character.isDigit(board[i][j]) && rowNum.contains(board[i][j])) {
//					return false;
//				} else {
//					rowNum.add(board[i][j]);
//				}
//			}
//		}
//
//		return true;
//	}
//}