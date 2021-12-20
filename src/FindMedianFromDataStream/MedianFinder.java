package FindMedianFromDataStream;
import java.util.*;
class MedianFinder {
	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;
	/** initialize your data structure here. */
	public MedianFinder() {
		left = new PriorityQueue<>( (a, b) -> {
			return Integer.compare(b, a);
		});

		right = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (left.size() == right.size()) {
			right.add(num);

			left.add(right.poll());
		} else if (left.size() > right.size()) {
			left.add(num);

			right.add(left.poll());
		}
	}

	public double findMedian() {
		if (left.size() == right.size()) {
			double median = (left.peek() + right.peek()) / 2.0;

			return median;
		}

		return left.peek();
	}

	public static void main(String[] args) {
		MedianFinder test = new MedianFinder();
		test.addNum(1);
		test.addNum(2);
		test.findMedian();
		test.addNum(3);
		test.findMedian();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */