package EmployeeFreeTime;
import java.util.*;

class Interval {
	public int start;
	public int end;

	public Interval() {}

	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
}

class Time {
	boolean start;
	int time;

	Time(boolean start, int time) {
		this.start = start;
		this.time = time;
	}



}

class Solution {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		PriorityQueue<Time> timing = new PriorityQueue<>(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				int timeCmp = Integer.compare(o1.time, o2.time);
				if (timeCmp != 0) return timeCmp;
				return o1.start == true && o2.start == false ? 1 : -1;
			}
		});


		for (List<Interval> intervals : schedule) {
			for (Interval interval : intervals) {
				timing.add(new Time(true, interval.start));
				timing.add(new Time(false, interval.end));
			}
		}
		List<Interval> res = new ArrayList<>();

		int openInterval = 0;
		while (!timing.isEmpty()) {
			Time curr = timing.poll();
			if (curr.start) {
				openInterval += 1;
			} else {
				openInterval -= 1;
			}

			if (openInterval == 0 && !timing.isEmpty()) {
				if (curr.time != timing.peek().time) {
					res.add(new Interval(curr.time, timing.peek().time));
				}

			}
		}

		return res;
	}

	public static void main(String[] args) {
		List<List<Interval>> schedule = new ArrayList<>();
		List<Interval> sch1 = new ArrayList<>();
		sch1.add(new Interval(91,94));
		sch1.add(new Interval(94,99));

//		List<Interval> sch2 = new ArrayList<>();
//		sch2.add(new Interval(1,3));
//		sch2.add(new Interval(4,10));

		schedule.add(sch1);
//		schedule.add(sch2);

		Solution test = new Solution();

		test.employeeFreeTime(schedule);
	}
}