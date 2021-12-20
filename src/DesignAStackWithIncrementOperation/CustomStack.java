package DesignAStackWithIncrementOperation;
import java.util.*;

class CustomStack {
	int maxSize;
	int ptr;
	int[] stack;

	public CustomStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[maxSize];
		this.ptr = -1;
	}

	public void push(int x) {
		if (ptr + 1 < maxSize) {
			ptr++;
			stack[ptr] = x;
		}
	}

	public int pop() {
		int res = -1;
		if (ptr > -1) {
			res = stack[ptr];
			ptr--;
		}

		return res;
	}

	public void increment(int k, int val) {
		for (int i = 0; i < k && i <= ptr; i++) {
			stack[i] += val;
		}
	}

	public static void main(String[] args) {
		CustomStack customStack = new CustomStack(3);
		customStack.push(1);                          // stack becomes [1]
		customStack.push(2);                          // stack becomes [1, 2]
		customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
		customStack.push(2);                          // stack becomes [1, 2]
		customStack.push(3);                          // stack becomes [1, 2, 3]
		customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
		customStack.increment(5, 100);                // stack becomes [101, 102, 103]
		customStack.increment(2, 100);                // stack becomes [201, 202, 103]
		customStack.pop();
		customStack.pop();
		customStack.pop();
		customStack.pop();

	}
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
