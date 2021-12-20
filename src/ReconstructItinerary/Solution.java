package ReconstructItinerary;
import java.util.*;

class Ticket {
	String from;
	String to;

	Ticket(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ticket ticket = (Ticket) o;
		return Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to);
	}
}

class Solution {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<String>> links = new HashMap<>();

		for (List<String> ticket : tickets) {
			links.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
		}

		HashMap<Ticket, Integer> originalTickets = new HashMap<>();
		for (int i = 0; i < tickets.size(); i ++) {
			Ticket ticket = new Ticket(tickets.get(i).get(0), tickets.get(i).get(1));
			originalTickets.put(ticket, originalTickets.getOrDefault(ticket, 0) + 1);
		}

		List<String> fromJFKs = links.get("JFK");
		ArrayList<String> res = new ArrayList<>();
		for (String fromJFK : fromJFKs) {
			Ticket ticket = new Ticket("JFK", fromJFK);
			HashMap<Ticket, Integer> ticketAvailable = originalTickets;
			ticketAvailable.put(ticket, ticketAvailable.get(ticket) - 1);
			findItineraryHelper(links, fromJFK, new StringBuilder("JFK"), res, ticketAvailable, tickets.size());
			ticketAvailable.put(ticket, ticketAvailable.get(ticket) + 1);
		}

		int x = 1;
		Collections.sort(res);

		List<String> result = new ArrayList<>();

		if (res.isEmpty()) return Collections.emptyList();
		String resultStr = res.get(0);
		for (int i = 0; i < resultStr.length(); i+= 3) {
			result.add(resultStr.substring(i , i + 3));
		}

		return result;
	}

	void findItineraryHelper(Map<String, List<String>> links, String currAirport,
							 StringBuilder intermediateRes, ArrayList<String> res, HashMap<Ticket, Integer> ticketAvailable, int totalTickets) {


		List<String> nextAirports = links.get(currAirport);
		intermediateRes.append(currAirport);

		if (intermediateRes.length() == (totalTickets + 1) * 3 ) {
			res.add(intermediateRes.toString());
			intermediateRes.delete(intermediateRes.length() - 3, intermediateRes.length());
			return;
		}

		if (nextAirports == null) {
			intermediateRes.delete(intermediateRes.length() - 3, intermediateRes.length());
			return;
		}

		for (String nextAirport : nextAirports) {
			Ticket ticket = new Ticket(currAirport, nextAirport);
			if (ticketAvailable.get(ticket) == 0) continue;
			ticketAvailable.put(ticket, ticketAvailable.get(ticket) - 1);
			findItineraryHelper(links, nextAirport, intermediateRes, res, ticketAvailable, totalTickets);
			ticketAvailable.put(ticket, ticketAvailable.get(ticket) + 1);

		}
		intermediateRes.delete(intermediateRes.length() - 3, intermediateRes.length());
 	}

	public static void main(String[] args) {
		Solution test = new Solution();
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
		tickets.add(new ArrayList<>(Arrays.asList("JFK", "ATL")));
		tickets.add(new ArrayList<>(Arrays.asList("SFO", "ATL")));
		tickets.add(new ArrayList<>(Arrays.asList("ATL", "JFK")));
		tickets.add(new ArrayList<>(Arrays.asList("ATL", "SFO")));

		test.findItinerary(tickets);
	}

}