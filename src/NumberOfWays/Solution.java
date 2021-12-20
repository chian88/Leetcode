package NumberOfWays;

class Solution {
	public int numOfWays(int n) {
		long c3 = 6;
		long c2 = 6;

		long mod = 1000000000 + 7;

		for (int i = 2; i <= n; i++) {
			long temp = c3;
			c3 = (2* c2 + 2*c3) % mod;
			c2 = (2 *temp + 3 * c2) % mod;
		}
		int ans = (int) ((c3 + c2) % mod);
		return ans;

	}
}