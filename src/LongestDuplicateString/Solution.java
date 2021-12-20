package LongestDuplicateString;
import java.util.*;

class Solution {

	String S;
	// Rabin Karp Algorithm.
	public int search(int L, int a, long modulus, int n, int[] nums) {
		long h = 0;
		for (int i = 0; i < L; ++i) {
			h = (h * a + nums[i]) % modulus;
		}

		HashMap<Long, List<Integer>> seen = new HashMap<Long, List<Integer>>();

		seen.putIfAbsent(h, new ArrayList<>());
		seen.get(h).add(0);

		long aL = 1;
		for (int i = 1; i <= L; ++i) {
			aL = (aL * a) % modulus;
		}

		for (int start = 1; start < n - L + 1; ++ start) {
			h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			h = (h + nums[start + L - 1]) % modulus;
			List<Integer> hits = seen.get(h);
			if (hits != null) {
				String cur = S.substring(start, start + L);
				for (Integer i : hits) {
					String candidate = S.substring(i, i + L);
					if (candidate.equals(cur)) {
						return i;
					}
				}
			}

			seen.putIfAbsent(h, new ArrayList<>());
			seen.get(h).add(start);
		}

		return -1;
	}

	public String longestDupSubstring(String s) {
		S = s;
		int n = S.length();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = (int) S.charAt(i) - (int) 'a';
		}

		int a = 26;

		int modulus = 1_000_000_007;

		int left = 1 , right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (search(mid, a, modulus, n, nums) != -1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		int start = search(left - 1, a, modulus, n , nums);
		return S.substring(start, start + left - 1);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestDupSubstring("leetcodecookies");
	}
}