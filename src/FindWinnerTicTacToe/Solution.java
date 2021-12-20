package FindWinnerTicTacToe;

class Solution {
	public String tictactoe(int[][] moves) {
		char[][] board = new char[3][3];
		boolean ATurn = true;
		for (int[] move : moves) {
			if (ATurn) {
				board[move[0]][move[1]] = 'X';
				if (win(board, 'X')) {
					return "A";
				}
			} else {
				board[move[0]][move[1]] = 'O';

				if (win(board, 'O')) {
					return "B";
				}
			}


			ATurn = !ATurn;
		}

		if (full(board)) {
			return "Draw";
		}

		return "Pending";
	}

	boolean full(char[][] board) {
		boolean full = true;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != 'X' && board[row][col] != 'O') {
					full = false;
				}
			}
		}

		return full;
	}

	boolean win(char[][] board, char player) {
		for (int row = 0; row < board.length; row++) {
			boolean win = true;

			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != player) {
					win = false;
				}
			}

			if (win) {
				return true;
			}
		}

		for (int col = 0; col < board[0].length; col++) {
			boolean win = true;

			for (int row = 0; row < board.length; row++) {
				if (board[row][col] != player) {
					win = false;
				}
			}

			if (win) {
				return true;
			}
		}

		int row = 0, col = 0;
		boolean win = true;
		while (row < board.length) {
			if (board[row][col] != player) {
				win = false;
			}

			row++;
			col++;
		}

		if (win) {
			return true;
		}

		row = 0;
		col = board[0].length - 1;

		win = true;
		while ( row < board.length) {
			if (board[row][col] != player) {
				win = false;
			}

			row++;
			col--;
		}

		if (win) {
			return true;
		}

		return false;

	}
}