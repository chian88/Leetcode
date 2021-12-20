package MaximumNumOfEventsThatCanBeAttended;
import java.util.*;


class Solution {
	public int maxEvents(int[][] events) {
		Arrays.sort(events, (a,b) -> {
			int endCmp = Integer.compare(a[1], b[1]);

			if (endCmp != 0) {
				return endCmp;
			}

			return Integer.compare(a[0], b[0]);
		});

		boolean[] freedays = new boolean[100000];
		int res = 0;
		for (int[] event : events) {
			for (int day = event[0]; day <= event[1]; day++) {
				if (freedays[day - 1] == false) {
					res += 1;
					freedays[day - 1] = true;
					break;
				}

			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxEvents(new int[][]{{1,5}, {1,5}, {1,5}, {2,3}, {2,3}});
	}
}