package NonOverlappingInterval;
import java.util.*;

class Time {
	int start;
	int end;

	Time (int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		List<Time> schedule = new ArrayList<>();
		for (int[] interval : intervals) {
			schedule.add(new Time(interval[0], interval[1]));
		}

		Collections.sort(schedule, (a, b) -> {
			int endCmp = Integer.compare(a.end, b.end);
			return endCmp;
		});

		int res = 0;

		int prevEnd = Integer.MIN_VALUE;

		for (Time t : schedule) {
			if (t.start < prevEnd) {
				res++;
			} else {
				prevEnd = t.end;
			}
		}

		return res;
	}
}