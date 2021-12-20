package BeautifulArrangement;
import java.util.*;

class Solution {
	public int countArrangement(int n) {
		boolean[] used = new boolean[n];

		int ans = recursion(n, used, 0);
		return ans;
	}

	int recursion(int n, boolean[] used, int idx) {
		if (idx >= n) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			int num = i + 1;

			if (used[num - 1]) {
				continue;
			}

			if (  (idx + 1) % num  == 0 || (num % (idx + 1)) == 0) {
				used[num - 1] = true;
				count += recursion(n, used, idx + 1);
				used[num - 1] = false;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countArrangement(3);
	}
}