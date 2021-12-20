package DesignTicTacToe;
import java.util.*;


class TicTacToe {
	int[] player1Row;
	int[] player2Row;
	int[] player1Col;
	int[] player2Col;
	int player1Diagonal = 0;
	int player2Diagonal = 0;
	int player1AntiDiagonal = 0;
	int player2AntiDiagonal = 0;
	int n;
	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		player1Row = new int[n];
		player2Row = new int[n];
		player1Col = new int[n];
		player2Col = new int[n];
		this.n = n;
	}

	/** Player {player} makes a move at ({row}, {col}).
	 @param row The row of the board.
	 @param col The column of the board.
	 @param player The player, can be either 1 or 2.
	 @return The current winning condition, can be either:
	 0: No one wins.
	 1: Player 1 wins.
	 2: Player 2 wins. */
	public int move(int row, int col, int player) {
		if (player == 1) {
			player1Row[row] += 1;
			if (player1Row[row] == n) {
				return player;
			}
			player1Col[col] += 1;
			if (player1Col[col] == n) {
				return player;
			}

			if (row == col) {
				player1Diagonal += 1;
				if (player1Diagonal == n) {
					return player;
				}
			}

			if (n - row - 1 == col) {
				player1AntiDiagonal += 1;
				if (player1AntiDiagonal == n) {
					return player;
				}
			}
		} else if (player == 2) {
			player2Row[row] += 1;
			if (player2Row[row] == n) {
				return player;
			}
			player2Col[col] += 1;
			if (player2Col[col] == n) {
				return player;
			}

			if (row == col) {
				player2Diagonal += 1;
				if (player2Diagonal == n) {
					return player;
				}
			}

			if (n - row - 1 == col) {
				player2AntiDiagonal += 1;
				if (player2AntiDiagonal == n) {
					return player;
				}
			}
		}
		return 0;
	}
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */