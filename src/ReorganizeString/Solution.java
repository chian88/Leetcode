package ReorganizeString;
import java.util.*;

class Solution {
	public static String reorganizeString(String s) {
		Map<Character, Integer> counter = new HashMap<>();



		for (char c : s.toCharArray()) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counter.get(b) - counter.get(a));

		maxHeap.addAll(counter.keySet());


		StringBuilder result = new StringBuilder();

		while(maxHeap.size() > 1) {
			char current = maxHeap.remove();
			char next = maxHeap.remove();

			result.append(current);
			result.append(next);

			counter.put(current, counter.get(current) - 1);
			counter.put(next, counter.get(next) - 1);

			if (counter.get(current) > 0) {
				maxHeap.add(current);
			}

			if (counter.get(next) > 0) {
				maxHeap.add(next);
			}
		}

		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (counter.get(last) > 1) {
				return "";
			}
			result.append(last);
		}




		return result.toString();
	}

	public static void main(String[] args) {
		reorganizeString("ogccckcwmbmxtsbmozli");
	}
}