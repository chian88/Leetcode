package MovingAverageFromDataStream;
import java.util.*;

class MovingAverage {
	Queue<Integer> q;
	int size;
	double sum ;
	public MovingAverage(int size) {
		q = new LinkedList<>();
		this.size = size;
		this.sum = 0.0;

	}

	public double next(int val) {
		sum += val;
		q.add(val);
		if (q.size() > size) {
			sum -= q.poll();
		}



		return sum / q.size();
	}

	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverage(3);
		movingAverage.next(1); // return 1.0 = 1 / 1
		movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
		movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3

	}
}





//class MovingAverage {
//	int size;
//	Deque<Integer> deque;
//	double currSum = 0.0;
//	/** Initialize your data structure here. */
//	public MovingAverage(int size) {
//		this.size = size;
//		this.deque = new ArrayDeque<>();
//	}
//
//	public double next(int val) {
//		this.deque.addLast(val);
//		currSum += val;
//
//		if (deque.size() > this.size) {
//			int removed = deque.pollFirst();
//			currSum -= removed;
//		}
//
//
//		return currSum / deque.size();
//	}
//}