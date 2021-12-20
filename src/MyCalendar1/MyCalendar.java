package MyCalendar1;
import java.util.*;


class MyCalendar {
	private TreeMap<Integer, Integer> calendar;
	public MyCalendar() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer earlierStart = calendar.floorKey(start);
		Integer laterStart = calendar.ceilingKey(start);

		if ( (earlierStart == null || calendar.get(earlierStart) <= start ) &&
				(laterStart == null || laterStart >= end)) {
			calendar.put(start, end);
			return true;
		}
		return false;
	}
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */