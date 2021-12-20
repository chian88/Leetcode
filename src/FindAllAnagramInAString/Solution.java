package FindAllAnagramInAString;
import java.util.*;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		int[] dp = new int[26];
		int[] memo = new int[26];
		if (p.length() > s.length()) {
			return Collections.emptyList();
		}
		for (int i = 0; i < p.length(); i++) {
			dp[p.charAt(i) - 'a'] += 1;
			memo[s.charAt(i) - 'a'] += 1;
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			if(same(dp, memo)) {
				ans.add(i);
			}
			memo[s.charAt(i) - 'a'] -= 1;

			if (i + p.length() < s.length()) {
				memo[s.charAt(i + p.length()) - 'a'] += 1;
			}

		}

		return ans;

	}

	boolean same(int[] dp, int[] memo) {
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] != memo[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
	}
}