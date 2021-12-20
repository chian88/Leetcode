package MinimumTimeDifference;
import java.util.*;

class Solution {
	public int findMinDifference(List<String> timePoints) {
		List<Integer> timePointInt = new ArrayList<>();

		for (String timePoint : timePoints) {
			timePointInt.add(convertToMinutes(timePoint));
		}

		Collections.sort(timePointInt);

		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < timePointInt.size() - 1; i++) {
			minDiff = Math.min(minDiff, timePointInt.get(i + 1) - timePointInt.get(i));
		}

		minDiff = Math.min(minDiff, (timePointInt.get(0) + 1440) - (timePointInt.get(timePointInt.size() - 1) ));

		return minDiff;

	}

	int convertToMinutes(String timePoint) {
		String[] time = timePoint.split(":");

		int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		return minutes;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findMinDifference(Arrays.asList("23:59", "00:00"));
	}
}