package FinalPricesWithSpecialDiscountInAshop;
import java.util.*;

class Solution {
	public int[] finalPrices(int[] prices) {
		Deque<Integer> q = new ArrayDeque<>();
		Deque<Integer> qIdx = new ArrayDeque<>();
		int[] res = new int[prices.length];
		int read = 1;


		q.addFirst(prices[0]);
		qIdx.addFirst(0);

		while (read < prices.length) {
			while (!q.isEmpty() && prices[read] <= q.peekFirst()) {
				res[qIdx.pollFirst()] = q.pollFirst() - prices[read];
			}

			q.addFirst(prices[read]);
			qIdx.addFirst(read);
			read++;
		}

		while (!q.isEmpty()) {
			res[qIdx.pollFirst()] = q.pollFirst();
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.finalPrices(new int[]{8,4,6,2,3});
	}
}