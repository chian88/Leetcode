package BattleshipInABoard;
import java.util.*;


class Solution {
	int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					count++;
					dfs(board, i, j);
				}
			}
		}
		return count;
	}

	void dfs(char[][] board, int row , int col) {
		board[row][col] = '.';


		for (int[] direction : directions) {
			if (row + direction[0] >= 0 && row + direction[0] < board.length
					&& col + direction[1] >= 0 && col + direction[1] < board[0].length) {
				if (board[row + direction[0]][col + direction[1]] == 'X') {
					dfs(board, row + direction[0], col + direction[1] );
				}
			}
		}
	}
}