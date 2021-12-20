package Matrix01;
import java.util.*;

class Solution {
	public int[][] updateMatrix(int[][] mat) {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					q.add(new int[]{i, j});
				}
			}
		}
		int[][] ans = new int[mat.length][mat[0].length];
		int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};
		int dist = 0;
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				int[] curr = q.poll();
				for (int[] dir : dirs) {
					int newRow = curr[0] + dir[0];
					int newCol = curr[1] + dir[1];

					if (newRow < mat.length && newRow >= 0
							&& newCol >= 0 && newCol < mat[0].length
							&& mat[newRow][newCol] == 1 && ans[newRow][newCol] == 0) {
						ans[newRow][newCol] = dist + 1;
						q.add(new int[]{newRow, newCol});
					}
				}
				levelSize--;
			}
			dist++;
		}

		return ans;
	}
}





//class Solution {
//	public int[][] updateMatrix(int[][] mat) {
//		int[][] res = new int[mat.length][mat[0].length];
//		int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//		Queue<int[]> q = new LinkedList<>();
//
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[i].length; j++) {
//				if (mat[i][j] == 0) {
//					q.add(new int[]{i, j});
//				}
//			}
//		}
//		int dist = 1;
//		while (!q.isEmpty()) {
//			int levelSize = q.size();
//
//			while (levelSize > 0) {
//				int[] curr = q.poll();
//
//
//				for (int[] direction : directions) {
//					int newRow = direction[0] + curr[0];
//					int newCol = direction[1] + curr[1];
//
//					if (newRow < 0 || newRow >= mat.length || newCol < 0 || newCol >= mat[0].length) {
//						continue;
//					}
//
//
//					if (mat[newRow][newCol] == 1 && res[newRow][newCol] == 0) {
//						res[newRow][newCol] = dist;
//						q.add(new int[]{newRow, newCol});
//					}
//				}
//
//
//				levelSize--;
//			}
//
//			dist++;
//		}
//
//		return res;
//	}
//}