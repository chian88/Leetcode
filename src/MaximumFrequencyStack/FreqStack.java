package MaximumFrequencyStack;
import java.util.*;

class FreqStack {
	Map<Integer, Integer> counter;
	PriorityQueue<int[]> heap;
	int ptr = 0;
	public FreqStack() {
		counter = new HashMap<>();
		heap = new PriorityQueue<>((a, b) -> {
			int countCmp = Integer.compare(b[1], a[1]);
			if (countCmp != 0) {
				return countCmp;
			}

			return Integer.compare(b[2], a[2]);
		});
	}

	public void push(int val) {
		if (!counter.containsKey(val)) {
			counter.put(val, 1);
			heap.add(new int[]{val, 1, ptr});
		} else {
			counter.put(val, counter.get(val) + 1);
			heap.add(new int[]{val, counter.get(val), ptr});
		}
		ptr++;
	}

	public int pop() {
		int[] item = heap.poll();
		counter.put(item[0], counter.get(item[0]) - 1);

		return item[0];
	}

	public static void main(String[] args) {
		FreqStack test = new FreqStack();

		test.push(5);
		test.push(7);
		test.push(5);
		test.push(7);
		test.push(4);
		test.push(5);
		test.pop();
		test.pop();
		test.pop();
		test.pop();
	}
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */