package MaxStack;
import java.util.*;



class MaxStack {
	private Deque<int[]> stack;
	/** initialize your data structure here. */
	public MaxStack() {
		this.stack = new ArrayDeque<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.addFirst(new int[]{x, x});
		} else {
			int[] prev = stack.peekFirst();
			stack.addFirst(new int[]{x, Math.max(x, prev[1])});
		}

	}

	public int pop() {
		return stack.pollFirst()[0];
	}

	public int top() {
		return stack.peekFirst()[0];
	}

	public int peekMax() {
		return stack.peekFirst()[1];
	}

	public int popMax() {
		Deque<int[]> tempStack = new ArrayDeque<>();

		int currentMax = stack.peekFirst()[1];

		while (stack.peekFirst()[0] != currentMax) {
			tempStack.addFirst(stack.pollFirst());
		}

		stack.pollFirst();

		while (!tempStack.isEmpty()) {
			int[] temp = tempStack.pollFirst();

			if (!stack.isEmpty()) {
				temp[1] = Math.max(temp[0], stack.peekFirst()[1]);
			} else {
				temp[1] = temp[0];
			}

			stack.addFirst(temp);
		}

		return currentMax;
	}

	public static void main(String[] args) {
		MaxStack test = new MaxStack();

		test.push(5);

		test.push(1);

		test.popMax();
		test.peekMax();

	}
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */