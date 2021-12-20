package MyCalendar2;
import java.util.*;

class MyCalendarTwo {
	TreeMap<Integer, List<Integer>> schedule;
	public MyCalendarTwo() {
		schedule = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		List<Integer> beforeStart = null;
		if (schedule.floorKey(start) != null) {
			beforeStart = schedule.get(schedule.floorKey(start));
		}

		List<Integer> beforeEnd = null;
		if (schedule.floorKey(end) != null) {
			beforeEnd = schedule.get(schedule.floorKey(end));
		}


		int clashed = 0;

		if (beforeStart != null) {
			for (int time : beforeStart) {
				if (time > start) {
					clashed++;
				}
			}
		}

		if (beforeEnd != null) {
			for (int time : beforeEnd) {
				if (time > end) {
					clashed++;
				}
			}
		}

		if (clashed > 2) {
			return false;
		}
		if (!schedule.containsKey(start)) {
			schedule.put(start, new ArrayList<>());
		}
		schedule.get(start).add(end);
		return true;
	}

	public static void main(String[] args) {
		MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
		myCalendarTwo.book(10, 20); // return True, The event can be booked.
		myCalendarTwo.book(50, 60); // return True, The event can be booked.
		myCalendarTwo.book(10, 40); // return True, The event can be double booked.
		myCalendarTwo.book(5, 15);  // return False, The event ca not be booked, because it would result in a triple booking.
		myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
		myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
	}
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */