package FindWinnerOfTheCircularGame;
import java.util.*;

class Solution {
	public int findTheWinner(int n, int k) {
		Queue<Integer> circularQueue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			circularQueue.add(i);
		}

		while (circularQueue.size() > 1) {
			int count = k;
			while (count > 1) {
				int num = circularQueue.poll();
				circularQueue.add(num);
				count--;
			}

			circularQueue.poll();
		}

		return circularQueue.poll();
	}

}