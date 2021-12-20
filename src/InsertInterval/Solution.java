package InsertInterval;
import java.util.*;


class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();
		boolean merged = false;
		for (int i = 0; i < intervals.length; i++) {
			if (newInterval[1] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
				merged = true;
				int left = Math.min(newInterval[0], intervals[i][0]);
				int right = Math.max(newInterval[1], intervals[i][1]);

				int next = i + 1;

				while (next < intervals.length && intervals[next][0] <= right) {
					right = Math.max(right, intervals[next][1]);
					next++;
				}

				res.add(new int[]{left, right});
				i = next - 1;

			} else {
				res.add(new int[]{intervals[i][0], intervals[i][1]});
			}
		}

		if (!merged) {
			res.add(new int[]{newInterval[0], newInterval[1]});
			Collections.sort(res, (a,b) -> a[0] - b[0]);
		}

		int[][] ans = new int[res.size()][2];

		for (int i = 0;i < res.size(); i++) {
			ans[i] = res.get(i);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.insert(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8});
	}
}
