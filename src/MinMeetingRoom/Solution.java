package MinMeetingRoom;
import java.util.*;

class Solution {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int runningRooms = 0;
		int max = 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < intervals.length; i++) {
			if (minHeap.isEmpty() || minHeap.peek() > intervals[i][0]) {
				runningRooms++;
				max = Math.max(max, runningRooms);
			} else if (minHeap.peek() <= intervals[i][0]) {
				minHeap.poll();
			}

			minHeap.add(intervals[i][1]);
		}
		return max;
	}
}


//class Schedule {
//	int time;
//	boolean open;
//
//	Schedule(int time, boolean open) {
//		this.time = time;
//		this.open = open;
//	}
//}
//
//class Solution {
//	public static int minMeetingRooms(int[][] intervals) {
//		List<Schedule> scheduler = new ArrayList<>();
//
//		for (int[] interval : intervals) {
//			scheduler.add(new Schedule(interval[0], true));
//			scheduler.add(new Schedule(interval[1], false));
//		}
//
//		scheduler.sort( (a, b) -> {
//			int timeCmp = Integer.compare(a.time, b.time);
//
//			if (timeCmp != 0) return timeCmp;
//
//			return (a.open == true && b.open == false) ? 1 : -1;
//		} );
//
//
//		int max = Integer.MIN_VALUE;
//		int runningRoom = 0;
//		for (Schedule schedule : scheduler) {
//			if (schedule.open) {
//				runningRoom += 1;
//			} else {
//				runningRoom -= 1;
//			}
//
//			max = Math.max(max, runningRoom);
//		}
//		return max;
//	}
//
//	public static void main(String[] args) {
//		minMeetingRooms(new int[][] {{13,15}, {1,13}});
//	}
//}