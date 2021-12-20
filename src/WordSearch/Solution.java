package WordSearch;
import java.util.*;

class Point {
	int row;
	int col;

	Point (int row, int col) {
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
	public static boolean exist(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (existHelper(board, word, 0, row, col, new HashSet<>())) return true;
			}
		}
		return false;
	}

	static boolean existHelper(char[][] board, String word, int ptr, int row , int col, Set<Point> visited) {
		if (ptr >= word.length()) return true;

		if (visited.contains(new Point(row, col))) {
			return false;
		}

		if (board[row][col] == word.charAt(ptr)) {
			visited.add(new Point(row, col));
			// go to next state.
			if (row - 1 >= 0) {
				if (existHelper(board, word, ptr + 1, row - 1, col, visited)) return true;
			}
			if (row + 1 < board.length) {
				if (existHelper(board, word, ptr + 1, row + 1, col, visited)) return true;
			}
			if (col - 1 >= 0) {
				if (existHelper(board, word, ptr + 1, row, col - 1, visited)) return true;
			}
			if (col + 1 < board[row].length) {
				if (existHelper(board, word, ptr + 1, row, col + 1, visited)) return true;
			}

			if (ptr == word.length() - 1) return true;
			visited.remove(new Point(row, col));
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
		System.out.println(exist(board, "ABCESEEEFS"));
	}
}