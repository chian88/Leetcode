package MinimumKnightMove;
import java.util.*;


class Solution {
	public  static int minKnightMoves(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
				{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

		q.add(new int[]{0,0});
		int depth = 0;
		boolean[][] bitMap = new boolean[1000][1000];
		while (!q.isEmpty()) {

			int currentLevelSize = q.size();

			for (int i = 0; i < currentLevelSize; i++) {

				int[] current = q.poll();
				if (current[0] == x && current[1] == y) {
					return depth;
				}

				for (int[] offset : offsets) {
					int[] next = new int[]{current[0] + offset[0], current[1] + offset[1]};

					if (bitMap[next[0] + 500][next[1] + 500] != true) {
						bitMap[next[0] + 500][next[1] + 500] = true;
						q.add(next);
					}
				}




			}
			depth += 1;


		}

		return -1;
	}

	private static List<int[]> generateNextMoves(int[] currentPos) {
		List<int[]> res = new ArrayList<>();

		// top left
		res.add(new int[]{currentPos[0] - 1, currentPos[1]  + 2});
		// top right
		res.add(new int[]{currentPos[0]  + 1, currentPos[1] + 2});
		// right top
		res.add(new int[]{currentPos[0]  + 2, currentPos[1] + 1});
		// right down
		res.add(new int[]{currentPos[0]  + 2, currentPos[1] - 1});
		// down right
		res.add(new int[]{currentPos[0]  + 1, currentPos[1] - 2});
		// down left
		res.add(new int[]{currentPos[0]  - 1, currentPos[1] - 2});
		//left down
		res.add(new int[]{currentPos[0]  - 2, currentPos[1] - 1});
		// left up
		res.add(new int[]{currentPos[0]  - 2, currentPos[1] + 1});

		return res;
	}

	public static void main(String[] args) {
		int output = minKnightMoves(5,5);
		int y = 1;
	}
}