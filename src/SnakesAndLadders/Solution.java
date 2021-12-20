package SnakesAndLadders;
import java.util.*;

class Solution {
	public static int snakesAndLadders(int[][] board) {
		int moves = 0;
		int n = board.length;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		boolean foundGoal = false;

		boolean[][] visited = new boolean[n][n];
		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				int curr = q.poll();
				if (curr == n * n) {
					foundGoal = true;
					return moves;
				}

				List<Integer> nextMoves = generateNextNumbers(curr, n, board, visited);
				q.addAll(nextMoves);
			}

			moves += 1;
		}

		return foundGoal == true ? moves : -1;
	}

	public static List<Integer> generateNextNumbers(int num, int n, int[][] board, boolean[][] visited) {
		List<Integer> res = new ArrayList<>();

		int min = num + 1;
		int max = Math.min(num + 6, (int) Math.pow(n, 2));

		for (int i = min; i <= max ; i++) {

			int[] coordinate = convertNumToCell(i, n);

			if (board[coordinate[0]][coordinate[1]] != -1
					&& board[coordinate[0]][coordinate[1]] != num
					&& !visited[coordinate[0]][coordinate[1]]) {
				res.add(board[coordinate[0]][coordinate[1]]);
				visited[coordinate[0]][coordinate[1]] = true;
			} else if (board[coordinate[0]][coordinate[1]] != num
					&& !visited[coordinate[0]][coordinate[1]]) {
				res.add(i);
				visited[coordinate[0]][coordinate[1]] = true;
			}

		}
		return res;
	}

	public static int[] convertNumToCell(int num, int n) {
		int row = n - 1 - ((num - 1) / n);

		int rowInGame = (n - 1 - row);

		int col = num - 1 - (rowInGame * n);
		if (rowInGame % 2 == 1) {
			col = n - 1 - col;
		}

		return new int[]{row, col};
	}

	public static void main(String[] args) {
		//int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		int[][] board = {{1,1,-1}, {1,1,1}, {-1,1,1}};
 		snakesAndLadders(board);
	}
}