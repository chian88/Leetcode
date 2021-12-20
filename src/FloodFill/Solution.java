package FloodFill;
import java.util.*;


class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) {
			return image;
		}

		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int originalColor = image[sr][sc];
		q.add(new int[]{sr, sc});
		image[sr][sc] = newColor;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] dir : dirs) {
				int newRow = curr[0] + dir[0];
				int newCol = curr[1] + dir[1];

				if (newRow >= 0 && newRow < image.length && newCol >= 0
						&& newCol < image[0].length && image[newRow][newCol] == originalColor) {
					image[newRow][newCol] = newColor;
					q.add(new int[]{newRow, newCol});
				}
			}

		}

		return image;
	}
}


//class Solution {
//	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//		int originalColor = image[sr][sc];
//		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//		if (originalColor == newColor) {
//			return image;
//		}
//		image[sr][sc] = newColor;
//		Queue<int[]> q = new LinkedList<>();
//		q.add(new int[]{sr, sc});
//		boolean[][] visited = new boolean[image.length][image[0].length];
//
//		visited[sr][sc] = true;
//
//		while (!q.isEmpty()) {
//			int[] curr = q.poll();
//
//			for (int[] dir : dirs) {
//				int newRow = curr[0] + dir[0];
//				int newCol = curr[1] + dir[1];
//
//				if (newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length) {
//					continue;
//				}
//
//				if (image[newRow][newCol] == originalColor && !visited[newRow][newCol]) {
//					image[newRow][newCol] = newColor;
//					q.add(new int[]{newRow, newCol});
//				}
//			}
//		}
//
//		return image;
//	}
//}