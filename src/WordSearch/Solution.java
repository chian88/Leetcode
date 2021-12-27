package WordSearch;
import java.util.*;

class Solution {
	String word;
	char[][] board;
	int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public boolean exist(char[][] board, String word) {
		this.word = word;
		this.board = board;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (backtracking(i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean backtracking(int row, int col, int idx) {
		if (idx >= word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length
				|| col < 0 || col >= board[0].length
				|| board[row][col] != word.charAt(idx)) {
			return false;
		}


		board[row][col] = '#';
		boolean res = false;
		for (int[] dir : dirs) {
			res = backtracking(row + dir[0], col + dir[1], idx + 1);
			if (res) {
				break;
			}
		}

		board[row][col] = word.charAt(idx);

		return res;
	}
}

//class Point {
//	int row;
//	int col;
//
//	Point (int row, int col) {
//		this.row = row;
//		this.col = col;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Point point = (Point) o;
//		return row == point.row && col == point.col;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(row, col);
//	}
//}
//
//class Solution {
//	public static boolean exist(char[][] board, String word) {
//		for (int row = 0; row < board.length; row++) {
//			for (int col = 0; col < board[row].length; col++) {
//				if (existHelper(board, word, 0, row, col, new HashSet<>())) return true;
//			}
//		}
//		return false;
//	}
//
//	static boolean existHelper(char[][] board, String word, int ptr, int row , int col, Set<Point> visited) {
//		if (ptr >= word.length()) return true;
//
//		if (visited.contains(new Point(row, col))) {
//			return false;
//		}
//
//		if (board[row][col] == word.charAt(ptr)) {
//			visited.add(new Point(row, col));
//			// go to next state.
//			if (row - 1 >= 0) {
//				if (existHelper(board, word, ptr + 1, row - 1, col, visited)) return true;
//			}
//			if (row + 1 < board.length) {
//				if (existHelper(board, word, ptr + 1, row + 1, col, visited)) return true;
//			}
//			if (col - 1 >= 0) {
//				if (existHelper(board, word, ptr + 1, row, col - 1, visited)) return true;
//			}
//			if (col + 1 < board[row].length) {
//				if (existHelper(board, word, ptr + 1, row, col + 1, visited)) return true;
//			}
//
//			if (ptr == word.length() - 1) return true;
//			visited.remove(new Point(row, col));
//		}
//
//		return false;
//	}
//
//	public static void main(String[] args) {
//		char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//		System.out.println(exist(board, "ABCESEEEFS"));
//	}
//}