package LeastNumOfPerfectSquare;
import java.util.*;

class Solution {
	Set<Integer> square_nums = new HashSet<>();

	protected boolean is_divided_by(int n, int count) {
		if (count == 1) {
			return square_nums.contains(n);
		}

		for (Integer square : square_nums) {
			if (is_divided_by(n - square, count - 1)) {
				return true;
			}
		}

		return false;
	}

	public int numSquares(int n) {
		this.square_nums.clear();

		for (int i = 1; i * i <= n; ++i) {
			this.square_nums.add(i * i);
		}

		int count = 1;
		for (; count <= n; ++count) {
			if (is_divided_by(n, count)) {
				return count;
			}



		}
		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numSquares(12);
	}

}

//class Solution {
//	public int numSquares(int n) {
//		Integer[] dp = new Integer[n + 1];
//		int ans = recursion(n, dp);
//		return ans;
//	}
//
//	int recursion(int n, Integer[] dp) {
//		if (n <= 0) {
//			return 0;
//		}
//
//		if (dp[n] != null) {
//			return dp[n];
//		}
//
//		int limit = (int) Math.floor(Math.sqrt(n));
//		int res = Integer.MAX_VALUE;
//		for (int i = limit; i > 0; i--) {
//			int square = i * i;
//
//			res = Math.min(res, recursion(n - square, dp) + 1);
//		}
//		dp[n] = res;
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.numSquares(12);
//	}
//}
//













//class Solution {
//	public int numSquares(int n) {
//
//		Integer[] dp = new Integer[n];
//		int ans = recursion(n, dp);
//
//		return ans;
//	}
//
//	int recursion (int n, Integer[] dp) {
//		if (n <= 0) {
//			return 0;
//		}
//
//		if (dp[n - 1] != null) {
//			return dp[n - 1];
//		}
//		int max = (int) Math.floor(Math.sqrt(n));
//		int res = Integer.MAX_VALUE;
//		for (int i = max; i > 0; i--) {
//			int square = i * i;
//
//			res = Math.min(res, recursion(n - square, dp));
//		}
//		dp[n - 1] = res + 1;
//		return res + 1;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.numSquares(13);
//	}
//}