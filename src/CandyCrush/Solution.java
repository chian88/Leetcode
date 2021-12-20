package CandyCrush;
import java.util.*;

class Point {
	int i;
	int j;

	Point (int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return i == point.i && j == point.j;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}

}

class Solution {
	public static int[][] candyCrush(int[][] board) {

		boolean gotChange = false;
		do {
			gotChange = false;
			boolean[][] visited = new boolean[board.length][board[0].length];
			Set<Point> cellsToEmpty = new HashSet<>();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (visited[i][j] != true) {
						cellsToEmpty.addAll(collectSameType(board, i, j, "horizontal", visited));
						cellsToEmpty.addAll(collectSameType(board, i, j, "vertical", visited));
						int x = 1;
					}

				}
			}

			if (!cellsToEmpty.isEmpty()) {
				gotChange = true;

				Map<Integer, List<Integer>> colToRow = new HashMap<>();



				for (Point cells : cellsToEmpty) {
					colToRow.putIfAbsent(cells.j, new ArrayList<>());
					colToRow.get(cells.j).add(cells.i);
				}

				for (int col : colToRow.keySet()) {
					List<Integer> rows = colToRow.get(col);
					Collections.sort(rows);

					for (int row : rows) {
						int newRow = row - 1;
						while (newRow >= 0) {
							board[row][col] = board[newRow][col];
							row = newRow;
							newRow -= 1;
						}
						board[row][col] = 0;
					}
				}

				int y = 1;
			}

		} while (gotChange);

		return board;
	}

	static Set<Point> collectSameType(int[][] board, int i, int j, String direction, boolean[][] visited) {
		Set<Point> res = new HashSet<>();
		int originalValue = board[i][j];

		if (originalValue == 0) return new HashSet<>();
		visited[i][j] = true;

		if (direction.equals("horizontal")) {
			int count = 1;

			Set<Point> horizontalRes = new HashSet<>();
			horizontalRes.add(new Point(i, j));

			int newJLeft = j - 1;
			while (newJLeft >= 0 && board[i][newJLeft] == originalValue) {
				horizontalRes.add(new Point(i, newJLeft));
				count++;
				visited[i][newJLeft] = true;
				newJLeft--;
			}

			int newJRight = j + 1;
			while (newJRight < board[0].length && board[i][newJRight] == originalValue) {
				horizontalRes.add(new Point(i, newJRight));
				count++;
				visited[i][newJRight] = true;
				newJRight++;
			}

			if (count >= 3) {
				res.addAll(horizontalRes);
			}
		} else if (direction.equals("vertical")) {

			int count = 1;

			Set<Point> verticalRes = new HashSet<>();
			verticalRes.add(new Point(i, j));

			int newITop = i - 1;
			while (newITop >= 0 && board[newITop][j] == originalValue) {
				verticalRes.add(new Point(newITop, j));
				count++;
				visited[newITop][j] = true;
				newITop--;
			}

			int newIDown = i + 1;
			while (newIDown < board.length && board[newIDown][j] == originalValue) {
				verticalRes.add(new Point(newIDown, j));
				count++;
				visited[newIDown][j] = true;
				newIDown++;
			}

			if (count >= 3) {
				res.addAll(verticalRes);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		//int[][] board = new int[][] {{1,3,5,5,2}, {3,4,3,3,1}, {3,2,4,5,2}, {2,4,4,5,5}, {1,4,4,1,1}};
		int[][] board= new int[][] {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
		candyCrush(board);
	}
}