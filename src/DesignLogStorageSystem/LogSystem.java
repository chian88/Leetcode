package DesignLogStorageSystem;
import java.util.*;

class LogSystem {
	private int minuteToSecond = 60;
	private int hourToMinute = 60;
	private int dayToHour = 24;
	private int monthToDay = 31;
	private int yearToMonth = 12;
	private Map<Long, Integer> storage;

	public LogSystem() {
		storage = new HashMap<>();
	}

	public void put(int id, String timestamp) {
		String[] timeStamps = timestamp.split(":");
		long yearInSecond = (Long.parseLong(timeStamps[0]) - 1999L) * yearToMonth * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long monthInSecond = Long.parseLong(timeStamps[1]) * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long dayInSecond = Long.parseLong(timeStamps[2]) * dayToHour * hourToMinute * minuteToSecond;
		long hourInSecond = Long.parseLong(timeStamps[3]) * hourToMinute * minuteToSecond;
		long minuteInSecond = Long.parseLong(timeStamps[4]) * minuteToSecond;

		long totalSecond = yearInSecond + monthInSecond + dayInSecond + hourInSecond + minuteInSecond + Long.parseLong(timeStamps[5]);
		storage.put(totalSecond, id);

	}

	public List<Integer> retrieve(String start, String end, String granularity) {
		String[] timeStampsStart = start.split(":");
		long yearInSecondStart = (Long.parseLong(timeStampsStart[0]) - 1999L)  * yearToMonth * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long monthInSecondStart = Long.parseLong(timeStampsStart[1]) * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long dayInSecondStart = Long.parseLong(timeStampsStart[2]) * dayToHour * hourToMinute * minuteToSecond;
		long hourInSecondStart = Long.parseLong(timeStampsStart[3]) * hourToMinute * minuteToSecond;
		long minuteInSecondStart = Long.parseLong(timeStampsStart[4]) * minuteToSecond;

		String[] timeStampsEnd = end.split(":");
		long yearInSecondEnd = (Long.parseLong(timeStampsEnd[0]) - 1999L)  * yearToMonth * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long monthInSecondEnd = Long.parseLong(timeStampsEnd[1]) * monthToDay * dayToHour * hourToMinute * minuteToSecond;
		long dayInSecondEnd = Long.parseLong(timeStampsEnd[2]) * dayToHour * hourToMinute * minuteToSecond;
		long hourInSecondEnd = Long.parseLong(timeStampsEnd[3]) * hourToMinute * minuteToSecond;
		long minuteInSecondEnd = Long.parseLong(timeStampsEnd[4]) * minuteToSecond;


		long totalSecondStart = yearInSecondStart ;
		long totalSecondEnd = yearInSecondEnd;
		List<Integer> res = new ArrayList<>();

		if (granularity.equals("Year")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		totalSecondStart += monthInSecondStart ;
		totalSecondEnd += monthInSecondEnd;

		if (granularity.equals("Month")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		totalSecondStart += dayInSecondStart ;
		totalSecondEnd += dayInSecondEnd;

		if (granularity.equals("Day")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		totalSecondStart += hourInSecondStart ;
		totalSecondEnd += hourInSecondEnd;

		if (granularity.equals("Hour")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		totalSecondStart += minuteInSecondStart ;
		totalSecondEnd += minuteInSecondEnd;

		if (granularity.equals("Minute")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		totalSecondStart += Long.parseLong(timeStampsStart[5]) ;
		totalSecondEnd += Long.parseLong(timeStampsEnd[5]);

		if (granularity.equals("Second")) {
			for (Map.Entry<Long , Integer> log : storage.entrySet()) {
				if (log.getKey() >= totalSecondStart && log.getKey() <= totalSecondEnd) {
					res.add(log.getValue());
				}
			}

			return res;
		}

		return null;
	}


	public static void main(String[] args) {
		LogSystem logSystem = new LogSystem();
		logSystem.put(1, "2017:01:01:23:59:59");
		logSystem.put(2, "2017:01:01:22:59:59");
		logSystem.put(3, "2016:01:01:00:00:00");

		logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
		logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");

	}
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */