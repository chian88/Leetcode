package HitCounter;
import java.util.*;

class HitCounter {
	Queue<Integer> q ;
	public HitCounter() {
		q = new LinkedList<>();
	}

	public void hit(int timestamp) {
		q.add(timestamp);
	}

	public int getHits(int timestamp) {
		while (!q.isEmpty()) {
			if (timestamp - 300 >= q.peek()) {
				q.poll();
			} else {
				break;
			}
		}

		return q.size();
	}

	public static void main(String[] args) {
		HitCounter test = new HitCounter();
		test.hit(1);
		test.hit(2);
		test.hit(3);
		test.getHits(4);
		test.hit(300);
		test.getHits(300);
		test.getHits(301);
	}
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

//class HitCounter {
//	int id = 0;
//	int[] timeStamps = new int[1000];
//	public HitCounter() {
//		Arrays.fill(this.timeStamps, -1);
//	}
//
//	/** Record a hit.
//	 @param timestamp - The current timestamp (in seconds granularity). */
//	public void hit(int timestamp) {
//		this.timeStamps[id++] = timestamp;
//	}
//
//	/** Return the number of hits in the past 5 minutes.
//	 @param timestamp - The current timestamp (in seconds granularity). */
//	public int getHits(int timestamp) {
//		int min = 0;
//		min = Math.max(0, timestamp - 300);
//		int count = 0;
//		for (int i = 0; i < timeStamps.length; i++) {
//			if (timeStamps[i] > min && timeStamps[i] <= timestamp) {
//				count++;
//			}
//		}
//
//		return count;
//	}
//
//	public static void main(String[] args) {
//		HitCounter hitCounter = new HitCounter();
//		hitCounter.hit(1);       // hit at timestamp 1.
//		hitCounter.hit(2);       // hit at timestamp 2.
//		hitCounter.hit(3);       // hit at timestamp 3.
//		hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
//		hitCounter.hit(300);     // hit at timestamp 300.
//		hitCounter.getHits(300); // get hits at timestamp 300, return 4.
//		hitCounter.getHits(301); // get hits at timestamp 301, return 3
//	}
//}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */