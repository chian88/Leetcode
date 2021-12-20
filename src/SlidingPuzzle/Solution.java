package SlidingPuzzle;
import java.util.*;

class Solution {
	Map<Integer, int[]> map = new HashMap<>();

	public int slidingPuzzle(int[][] board) {
		map.put(0, new int[]{1,3});
		map.put(1, new int[]{0,2,4});
		map.put(2, new int[]{1,5});
		map.put(3, new int[]{0,4});
		map.put(4, new int[]{1,3,5});
		map.put(5, new int[]{2,4});
		Queue<String> q = new LinkedList<>();
		String brd = convertBoardToString(board);
		q.add(brd);
		Set<String> visited = new HashSet<>();
		visited.add(brd);
		int dist = 0;

		String target = "123450";
		if (brd.equals(target)) {
			return dist;
		}

		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				String curr = q.poll();

				for (String nextBoard : generateNextBoard(curr)) {
					if (nextBoard.equals(target)) {
						return dist+1;
					}

					if (!visited.contains(nextBoard)) {
						visited.add(nextBoard);
						q.add(nextBoard);
					}
				}

				levelSize--;
			}
			dist++;
		}
		return -1;
	}

	List<String> generateNextBoard(String board) {
		int zeroIndx = board.indexOf('0');

		int[] swaps = map.get(zeroIndx);
		List<String> res = new ArrayList<>();
		for (int swap : swaps) {
			StringBuilder next = new StringBuilder(board);
			char temp = next.charAt(swap);
			next.deleteCharAt(zeroIndx);
			next.insert(zeroIndx, temp);
			next.deleteCharAt(swap);
			next.insert(swap, 0);
			res.add(next.toString());
		}

		return res;
	}



	String convertBoardToString(int[][] board) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				str.append(board[i][j]);
			}
		}

		return str.toString();
	}
}