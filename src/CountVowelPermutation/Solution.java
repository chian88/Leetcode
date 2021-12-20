package CountVowelPermutation;
import java.util.*;

class Solution {
	Map<Integer, List<Integer>> map;


	public int countVowelPermutation(int n) {
		map = new HashMap<>();
		map.put(0, new ArrayList<>(Arrays.asList(1,2,4)));
		map.put(1, new ArrayList<>(Arrays.asList(0,2)));
		map.put(2, new ArrayList<>(Arrays.asList(1,3)));
		map.put(3, new ArrayList<>(Arrays.asList(2)));
		map.put(4, new ArrayList<>(Arrays.asList(2,3)));

		long[][] dp = new long[5][n + 1];
		long ans = 0;
		for (int i = 0; i < 5; i++) {
			ans = (ans + recursion(n - 1, i, dp)) % 1000000007;
		}

		int res = (int) ans;
		return res;
	}

	long recursion(int n, int curr, long[][] dp) {
		if (n == 0) {
			return 1;
		}

		if (dp[curr][n] > 0) {
			return dp[curr][n] % 1000000007;
		}

		List<Integer> candidates = map.get(curr);
		long count = 0;
		for (Integer candidate : candidates) {
			count += (recursion(n - 1, candidate, dp));
		}

		dp[curr][n] = count % 1000000007;

		return count % 1000000007;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countVowelPermutation(144);
	}
}