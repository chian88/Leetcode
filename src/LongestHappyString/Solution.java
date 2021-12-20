package LongestHappyString;
import java.util.*;

class Pair {
	int count;
	char c;

	Pair (char c, int count) {
		this.c = c;
		this.count = count;
	}
}

class Solution {
	public String longestDiverseString(int a, int b, int c) {
		PriorityQueue<Pair> heap = new PriorityQueue<>( (o1, o2) -> o2.count - o1.count);

		if (a > 0) {
			heap.add(new Pair('a', a));
		}

		if (b > 0) {
			heap.add(new Pair('b', b));
		}

		if (c > 0) {
			heap.add(new Pair('c', c));
		}
		StringBuilder rs = new StringBuilder();

		LinkedList<Pair> addback = new LinkedList<>();

		while (heap.size() > 0) {
			Pair top = heap.poll();
			addback.addLast(top);

			if (rs.length() > 1 && top.c == rs.charAt(rs.length() - 1) && top.c == rs.charAt(rs.length() - 2)) {
				continue;
			}

			rs.append(top.c);
			top.count -= 1;

			while (addback.size() > 0) {
				Pair item = addback.pollFirst();
				if (item.count > 0) {
					heap.add(item);
				}
			}
		}

		return rs.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestDiverseString(0, 8, 11);
	}
}