package MeetingScheduler;
import java.util.*;


class Solution {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		Arrays.sort(slots2, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		int p1 = 0;
		int p2 = 0;

		List<Integer> res = new ArrayList<>();

		while (p1 < slots1.length && p2 < slots2.length) {
			int end =  Math.min(slots1[p1][1], slots2[p2][1]);
			int start = Math.max(slots1[p1][0], slots2[p2][0]);

			int potential = end - start;

			if (potential >= duration) {
				res.add(start);
				res.add(start + duration);
				return res;
			}
			if (slots1[p1][1] < slots2[p2][1]) {
				p1++;
			} else {
				p2++;
			}

		}

		return res;
	}
}