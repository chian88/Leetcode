package CountSubmatricesWithAllOnes;
import java.util.*;


class Solution {
	public int numSubmat(int[][] mat) {
		int[][] prefix = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			int curr = 0;
			for (int j = mat[i].length - 1; j >= 0; j--) {
				if (mat[i][j] == 1) {
					curr += 1;
				} else {
					curr = 0;
				}

				prefix[i][j] = curr;

			}
		}
		int ans = 0;
		for (int i = 0; i < prefix.length; i++) {
			for (int j = 0; j < prefix[i].length; j++) {

				if (mat[i][j] == 1) {
					int x = Integer.MAX_VALUE;
					for (int k = i; k < mat.length; k++) {
						x = Math.min(x, prefix[k][j]);
						ans += x;
					}
				}

			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numSubmat(new int[][]{{1,0,1}, {1,1,0}, {1,1,0}});
	}
}