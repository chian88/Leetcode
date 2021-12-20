package TimeMapPackage;
import com.sun.jdi.Value;

import java.util.*;

class ValueTimeStamp {
	String val;
	int time;

	ValueTimeStamp(String val, int time) {
		this.val = val;
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ValueTimeStamp that = (ValueTimeStamp) o;
		return time == that.time && val.equals(that.val);
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, time);
	}
}

class TimeMap {
	Map<String, List<ValueTimeStamp>> timeMap;
	/** Initialize your data structure here. */
	public TimeMap() {
		this.timeMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (timeMap.containsKey(key)) {
			List<ValueTimeStamp> timeList = timeMap.get(key);
			timeList.add(new ValueTimeStamp(value, timestamp));

		} else {
			List<ValueTimeStamp> timeList = new ArrayList<>();
			timeList.add(new ValueTimeStamp(value, timestamp));
			timeMap.put(key, timeList);
		}
	}

	public String get(String key, int timestamp) {
		if (timeMap.containsKey(key)) {
			List<ValueTimeStamp> timeList = timeMap.get(key);

			for (int i = timeList.size() - 1; i >= 0; i--) {
				ValueTimeStamp valueStamp = timeList.get(i);
				if (valueStamp.time <= timestamp) return valueStamp.val;
			}
		}

		return "";
	}

	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();

		timeMap.set("foo", "bar", 1);
		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
		timeMap.get("foo", 1);         // return "bar"
		timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
		timeMap.get("foo", 4);         // return "bar2"
		timeMap.get("foo", 5);
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */