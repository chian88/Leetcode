package MinimumCostToConnectStick;
import java.util.*;

class Solution {
	public int connectSticks(int[] sticks) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int stick : sticks) {
			heap.add(stick);
		}
		int sum = 0;
		while (heap.size() > 1) {
			int smallest1 = heap.poll();
			int smallest2 = heap.poll();
			int merged = smallest1 + smallest2;
			sum += merged;
			heap.add(merged);

		}

		return sum;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.connectSticks(new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009});
	}
}