package JobScheduling;
import java.util.*;

class Solution {

	public int findMaxProfit(List<List<Integer>> jobs, int[] startTime,  int[] memo, int position, int n) {
		if (position == n) return 0;

		if (memo[position] != -1) {
			return memo[position];
		}

		int nextIndex = findNextJob(startTime, jobs.get(position).get(1));


		int maxProfit = Math.max(findMaxProfit(jobs, startTime, memo, position + 1, n),
				jobs.get(position).get(2) + findMaxProfit(jobs, startTime, memo,nextIndex, n));

		return memo[position] = maxProfit;
	}

	private int findNextJob(int[] startTime, Integer lastEndTime) {
		int start = 0, end =startTime.length - 1, nextIndex = startTime.length;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (startTime[mid] >= lastEndTime) {
				nextIndex = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return nextIndex;
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		List<List<Integer>> jobs = new ArrayList<>();

		for (int i = 0; i < startTime.length; i++) {
			jobs.add(Arrays.asList(startTime[i], endTime[i], profit[i]));
		}


		jobs.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return Integer.compare(o1.get(0), o2.get(0));
			}
		});

		for (int i = 0; i < startTime.length; i++) {
			startTime[i] = jobs.get(i).get(0);
		}
		int[] memo = new int[startTime.length];
		Arrays.fill(memo, -1);
		return findMaxProfit(jobs, startTime, memo, 0, startTime.length);
	}
}