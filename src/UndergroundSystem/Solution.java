package UndergroundSystem;
import java.util.*;

class UndergroundSystem {

	class Ticket {
		String startStation;
		int startTime;

		public Ticket(String startStation, int startTime) {
			this.startTime = startTime;
			this.startStation = startStation;
		}
	}

	private Map<Integer, Ticket> ticketSet = new HashMap<>();
	private Map<String, Double[]> avgTime = new HashMap<>();

	public UndergroundSystem() {

	}

	public void checkIn(int id, String stationName, int t) {
		ticketSet.put(id, new Ticket(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		Ticket ticket = ticketSet.get(id);

		String route = ticket.startStation + "-" + stationName;

		if (avgTime.containsKey(route)) {
			Double[] val = avgTime.get(route);
			val[0] += t-ticket.startTime;
			val[1] += 1;
		} else {
			avgTime.put(route, new Double[] { (double) t - ticket.startTime, 1.0});
		}

		ticketSet.remove(id);
	}

	public double getAverageTime(String startStation, String endStation) {
		String route = startStation + "-" + endStation;
		Double[] value = avgTime.get(route);

		return value[0] / value[1];
	}

	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
		undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
		undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
		undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
		undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
		undergroundSystem.checkIn(10, "Leyton", 24);
		undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
		undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
		undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
	}
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */