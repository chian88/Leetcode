package MineSweeper;
import java.util.*;

class Point {
	int row;
	int col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return row == point.row && col == point.col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
}


class Solution {
	public static char[][] updateBoard(char[][] board, int[] click) {
		char[][] newBoard = new char[board.length][board[0].length];

		Set<Point> visited = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0 ; j < board[i].length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		updateBoardHelper(newBoard, click, board, visited );

		return newBoard;
	}

	static void updateBoardHelper(char[][] newboard, int[] current, char[][] board, Set<Point> visited) {
		int row = current[0];
		int col = current[1];

		if (visited.contains(new Point(row, col))) {
			return;
		}

		if (row < 0 || row >= board.length) return;
		if (col < 0 || col >= board[0].length) return;


		char top = '\0';
		char topRight = '\0';
		char right = '\0';
		char downRight = '\0';
		char down = '\0';
		char downLeft = '\0';
		char left = '\0';
		char topLeft = '\0';

		int adjacentMines = 0;


		if (row - 1 >= 0) {
			top = board[row - 1][col];
			if (top == 'M') adjacentMines++;
		}
		if (row - 1 >= 0 && col + 1 < board[row].length) {
			topRight = board[row - 1][col + 1];
			if (topRight == 'M') adjacentMines++;
		}
		if (col + 1 < board[row].length) {
			right = board[row][col + 1];
			if (right == 'M') adjacentMines++;
		}
		if (row + 1 < board.length && col + 1 < board[row].length) {
			downRight = board[row + 1][col + 1];
			if (downRight == 'M') adjacentMines++;
		}
		if (row + 1 < board.length) {
			down = board[row + 1][col];
			if (down == 'M') adjacentMines++;
		}
		if (row + 1 < board.length && col - 1 >= 0 ) {
			downLeft = board[row + 1][ col - 1];
			if (downLeft == 'M') adjacentMines++;
		}
		if (col - 1 >= 0) {
			left = board[row][col - 1];
			if (left == 'M') adjacentMines++;
		}
		if (row - 1 >= 0 && col - 1 >= 0) {
			topLeft = board[row - 1][col - 1];
			if (topLeft == 'M') adjacentMines++;
		}

		char thisCell = board[row][col];
		visited.add(new Point(row, col));
		if (thisCell == 'M') {
			//

			newboard[row][col] = 'X';
		} else if (thisCell == 'E' ) {
			if( adjacentMines > 0) {
				newboard[row][col] = Character.forDigit(adjacentMines, 10);
				return;
			} else {
				newboard[row][col] = 'B';
			}

			// continue explore adjacent cells.

			// top
			updateBoardHelper(newboard, new int[]{current[0] - 1, current[1]}, board, visited);

			// topright
			updateBoardHelper(newboard, new int[]{current[0] - 1, current[1] + 1}, board, visited);

			// right
			updateBoardHelper(newboard, new int[]{current[0], current[1] + 1}, board, visited);

			// downRight
			updateBoardHelper(newboard, new int[]{current[0] + 1, current[1] + 1}, board, visited);

			// down
			updateBoardHelper(newboard, new int[]{current[0] + 1, current[1]}, board, visited);

			// downLeft
			updateBoardHelper(newboard, new int[]{current[0] + 1, current[1] - 1}, board, visited);

			// left
			updateBoardHelper(newboard, new int[]{current[0], current[1] - 1}, board, visited);

			// topLeft
			updateBoardHelper(newboard, new int[]{current[0] - 1, current[1] - 1}, board, visited);
		}


	}


	public static void main(String[] args) {
		char[][] board = new char[][] {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'} ,
				{'E', 'E', 'E', 'E', 'E'}};
		updateBoard(board, new int[]{3,0});
	}
}