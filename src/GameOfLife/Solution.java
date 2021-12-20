package GameOfLife;
import java.util.*;

class Solution {
	public static void gameOfLife(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				int up = 0;
				if (row - 1 >= 0) {
					up = board[row - 1][col];
				}

				int upRight = 0;
				if (row - 1 >= 0 && col + 1 < board[row].length) {
					upRight = board[row - 1][col + 1];
				}

				int right = 0;
				if (col + 1 < board[row].length) {
					right = board[row][col + 1];
				}

				int downRight = 0;
				if (row + 1 < board.length && col + 1 < board[row].length) {
					downRight = board[row + 1][col + 1];
				}

				int down = 0;
				if (row + 1 < board.length) {
					down = board[row + 1][col];
				}

				int downLeft = 0;
				if (row + 1 < board.length && col - 1 >= 0) {
					downLeft = board[row + 1][col - 1];
				}

				int left = 0;
				if (col - 1 >= 0) {
					left = board[row][col - 1];
				}

				int upLeft = 0;
				if (row - 1 >= 0 && col - 1 >= 0) {
					upLeft = board[row - 1][col - 1];
				}



				int current = board[row][col];
				int sum = up + upRight + right + downRight + down + downLeft + left + upLeft;

				if (current == 1) {
					// live
					if (sum < 2) {
						newBoard[row][col] = 0;
					} else if (sum > 3) {
						newBoard[row][col] = 0;
					} else {
						newBoard[row][col] = 1;
					}
				} else {
					if (sum == 3) {
						newBoard[row][col] = 1;
					} else {
						newBoard[row][col] = 0;
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = newBoard[i][j];
			}
		}
	}

	public static void main(String[] args) {
		gameOfLife(new int[][] {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}});
	}
}