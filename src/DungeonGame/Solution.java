package DungeonGame;

class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		int[][] dp = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					int required = dungeon[i][j];

					if (required >= 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.abs(dungeon[i][j]) + 1;
					}

					continue;
				}

				if (i + 1 < m && j < n) {
					// consider down and right
					int requiredDown = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
					int requiredRight = Math.max(1, dp[i][j + 1] - dungeon[i][j]);

					dp[i][j] = Math.min(requiredDown, requiredRight);

				} else if (i + 1 < m) {
					// consider down
					int required = dp[i + 1][j] - dungeon[i][j];

					dp[i][j] = Math.max(1, required);
				} else if (j + 1 < n) {
					// consider right

					int required = dp[i][j + 1] - dungeon[i][j];
					dp[i][j] = Math.max(1, required);
				}

			}
		}

		return dp[0][0];
	}
}