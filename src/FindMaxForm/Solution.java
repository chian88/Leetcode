package FindMaxForm;

class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
		int[] dp = new int[strs.length];
		int ans =  recursion(strs, m, n, 0, dp);
		return ans;
	}

	int recursion(String[] strs, int m, int n, int idx, int[] dp) {
		if (m == 0 && n == 0) {
			return 0;
		}

		if (idx >= strs.length) {
			return 0;
		}

		if (dp[idx] > 0) {
			return dp[idx];
		}

		int[] counter = new int[2];
		String str = strs[idx];

		for (char c : str.toCharArray()) {
			counter[c - '0'] += 1;
		}


		return -1;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.findMaxForm(new String[]{"001", "110","0000","0000"}, 9 ,2);
	}
}