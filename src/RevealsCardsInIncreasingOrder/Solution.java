package RevealsCardsInIncreasingOrder;
import java.util.*;

class Solution {
	public int[] deckRevealedIncreasing(int[] deck) {
		Deque<Integer> q = new ArrayDeque<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < deck.length; i++) {
			q.addLast(i);
			heap.add(deck[i]);
		}
		int[] res = new int[deck.length];
		while (!q.isEmpty()) {
			res[q.pollFirst()] = heap.poll();
			if(!q.isEmpty()) {
				q.addLast(q.pollFirst());
			}

		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
	}
}