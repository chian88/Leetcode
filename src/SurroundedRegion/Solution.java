package SurroundedRegion;
import java.util.*;


class Solution {
	public void solve(char[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];

		int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		List<int[]> toModify = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (visited[i][j] == false && board[i][j] == 'O') {
					Queue<int[]> q = new LinkedList<>();
					List<int[]> candidates = new ArrayList<>();

					q.add(new int[]{i, j});
					visited[i][j] = true;

					boolean surrounded = true;
					while (!q.isEmpty()) {
						int[] curr = q.poll();
						candidates.add(new int[]{curr[0], curr[1]});
						for (int[] direction : directions) {
							int newRow = curr[0] + direction[0];
							int newCol = curr[1] + direction[1];
							if (newRow < 0 || newRow >= board.length || newCol< 0 || newCol >= board[0].length) {
								surrounded = false;
							} else if (board[newRow][newCol] == 'O' && visited[newRow][newCol] == false) {
								visited[newRow][newCol] = true;
								q.add(new int[]{newRow, newCol});
							}
						}
					}

					if (surrounded) {
						toModify.addAll(candidates);
					}

				}
			}
		}

		for (int[] coor : toModify) {
			board[coor[0]][coor[1]] = 'X';
		}
	}
}