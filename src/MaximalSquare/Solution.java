package MaximalSquare;
import java.util.*;

class Solution {
	public int maximalSquare(char[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if ( (i == 0 || j == 0) && matrix[i][j] == '1') {
					dp[i][j] = 1;
				} else if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;

				}
				res = Math.max(res, dp[i][j]);
			}
		}

		return res * res;
	}

	public static void main(String[] args) {

		Solution test = new Solution();
		test.maximalSquare(new char[][]{{'0', '1'},
										{'1', '0'}});
	}
}


//class Solution {
//    public int maximalSquare(char[][] matrix) {
//        int[][] cache = new int[matrix.length][matrix[0].length];
//
//        int largestN = 0;
//
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                int top = 0;
//                int left = 0;
//                int topLeft = 0;
//
//                if ( row - 1 >= 0) {
//                    top = cache[row - 1][col];
//                }
//
//                if (col - 1 >= 0) {
//                    left = cache[row][col - 1];
//                }
//
//                if (row - 1 >= 0 && col - 1 >= 0) {
//                    topLeft = cache[row -1][col - 1];
//                }
//
//                if (matrix[row][col] == '1') {
//                    cache[row][col] = Math.min(Math.min(top, left), topLeft) + 1;
//                } else {
//                    cache[row][col] = 0;
//                }
//
//                if (cache[row][col] > largestN) {
//                    largestN = cache[row][col] ;
//                }
//            }
//        }
//        return (int) Math.pow(largestN, 2);
//    }
//
//
//
//
//    public static void main(String[] args) {
//        char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
//
//        Solution test = new Solution();
//        System.out.println(test.maximalSquare(arr));
//    }
//}