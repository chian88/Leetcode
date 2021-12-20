package NumberOfDistinctIsland;
import java.util.*;


class Solution {
	public int numIslands(char[][] grid) {
		Stack<int[]> stack = new Stack();
		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					stack.add(new int[]{i, j});
					res++;
					grid[i][j] = '0';

					while (!stack.isEmpty()) {
						int[] curr = stack.pop();

						for (int[] dir : dirs) {
							int newRow = curr[0] + dir[0];
							int newCol = curr[1] + dir[1];

							if (newRow >= 0 && newRow < grid.length
									&& newCol >= 0 && newCol < grid[0].length
									&& grid[newRow][newCol] == '1') {
								grid[newRow][newCol] = '0';
								stack.add(new int[]{newRow, newCol});
							}
						}

					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numIslands(new char[][]{{'1', '1', '1', '1', '0'}
		,{'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
	}
}



//class Solution {
//	public int numIslands(char[][] grid) {
//		int res = 0;
//
//		Queue<int[]> q = new LinkedList<>();
//		int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[i].length; j++) {
//				if (grid[i][j] == '1') {
//					q.add(new int[]{i, j});
//					grid[i][j] = '0';
//					res++;
//					while (!q.isEmpty()) {
//						int[] curr = q.poll();
//
//						for (int[] dir : dirs) {
//							int newRow = curr[0] + dir[0];
//							int newCol = curr[1] + dir[1];
//
//							if (newRow >= 0 && newRow < grid.length
//									&& newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
//								grid[newRow][newCol] = '0';
//								q.add(new int[]{newRow, newCol});
//							}
//						}
//					}
//				}
//			}
//		}
//
//		return res;
//	}
//}




















//class Solution {
//	public int numDistinctIslands(int[][] grid) {
//		boolean[][] visited = new boolean[grid.length][grid[0].length];
//		int output = 0;
//		List<List<int[]>> uniquePaths = new ArrayList<>();
//
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[i].length; j++) {
//				if (grid[i][j] == 1 && !visited[i][j]) {
//					List<int[]> path = dfs(grid, i, j, visited);
//					if (isUnique(uniquePaths, path)) {
//						uniquePaths.add(path);
//						output += 1;
//					}
//				}
//			}
//		}
//
//		return output;
//	}
//
//	boolean isUnique(List<List<int[]>> uniquePaths, List<int[]> path) {
//		boolean allUnique = true;
//		for (List<int[]> uniquePath : uniquePaths) {
//			if (uniquePath.size() != path.size()) continue;
//			boolean isUnique = false;
//			for (int i = 0; i < uniquePath.size() && i < path.size(); i++) {
//				int[] uniquePathCoor = uniquePath.get(i);
//				int[] pathCoor = path.get(i);
//
//				if (uniquePathCoor[0] != pathCoor[0] || uniquePathCoor[1] != pathCoor[1]) {
//					isUnique = true;
//					break;
//				}
//			}
//
//			if (isUnique == false) {
//				allUnique = false;
//				break;
//			}
//		}
//		return allUnique;
//
//	}
//
//	List<int[]> dfs(int[][] grid, int i, int j, boolean[][] visited) {
//		List<int[]> signaturePath = new ArrayList<>();
//		Deque<int[]> stack = new ArrayDeque<>();
//		stack.add(new int[]{i, j});
//
//		while (!stack.isEmpty()) {
//			int[] curr = stack.pollFirst();
//			visited[curr[0]][curr[1]] = true;
//			signaturePath.add(new int[] {curr[0] - i, curr[1] - j});
//			// top
//			if (curr[0] - 1 >= 0 &&
//					grid[curr[0] - 1][curr[1]] == 1 &&
//				visited[curr[0] - 1][curr[1]] == false) {
//				stack.addFirst(new int[]{curr[0] - 1, curr[1]});
//			}
//
//			// right
//			if (curr[1] + 1 < grid[0].length &&
//					grid[curr[0]][curr[1] + 1] == 1 &&
//					visited[curr[0]][curr[1] + 1] == false) {
//				stack.addFirst(new int[]{curr[0], curr[1] + 1});
//			}
//
//			// down
//			if (curr[0] + 1 < grid.length &&
//					grid[curr[0] + 1][curr[1]] == 1 &&
//					visited[curr[0] + 1][curr[1]] == false) {
//				stack.addFirst(new int[]{curr[0] + 1, curr[1]});
//			}
//			// left
//			if (curr[1] - 1 >= 0 &&
//					grid[curr[0]][curr[1] - 1] == 1 &&
//					visited[curr[0]][curr[1] - 1] == false) {
//				stack.addFirst(new int[]{curr[0], curr[1] - 1});
//			}
//		}
//
//		return signaturePath;
//	}
//}