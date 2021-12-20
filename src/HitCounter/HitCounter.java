package HitCounter;
import java.util.*;

class HitCounter {
	private Queue<Integer> hits;

	/** Initialize your data structure here. */
	public HitCounter() {
		this.hits = new LinkedList<Integer>();
	}

	/** Record a hit.
	 @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		this.hits.add(timestamp);
	}

	/** Return the number of hits in the past 5 minutes.
	 @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		while (!this.hits.isEmpty()) {
			int diff = timestamp - this.hits.peek();
			if (diff >= 300) this.hits.remove();
			else break;
		}
		return this.hits.size();
	}

	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		hitCounter.hit(1);       // hit at timestamp 1.
		hitCounter.hit(2);       // hit at timestamp 2.
		hitCounter.hit(3);       // hit at timestamp 3.
		hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
		hitCounter.hit(300);     // hit at timestamp 300.
		hitCounter.getHits(300); // get hits at timestamp 300, return 4.
		hitCounter.getHits(301); // get hits at timestamp 301, return 3
	}
}

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