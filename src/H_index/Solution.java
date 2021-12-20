package H_index;
import java.util.*;
import java.util.stream.IntStream;


class Solution {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n - i) {
				return n - i;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.hIndex(new int[]{11,15});
	}
}