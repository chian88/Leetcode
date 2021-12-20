package KthLargestElementInAStream;
import java.util.*;

class KthLargest {
	PriorityQueue<Integer> heap;
	int k;
	public KthLargest(int k, int[] nums) {
		heap = new PriorityQueue<>();
		this.k = k;
		for (int num : nums) {
			heap.add(num);
		}

		while (heap.size() > k) {
			heap.poll();
		}
	}

	public int add(int val) {
		heap.add(val);
		while (heap.size() > k) {
			heap.poll();
		}

		return heap.peek();

	}
}