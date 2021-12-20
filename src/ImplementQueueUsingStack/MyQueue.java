package ImplementQueueUsingStack;
import java.util.*;


class MyQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}

	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.peek();
	}

	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}


















//class MyQueue {
//	Deque<Integer> in;
//	Deque<Integer> out;
//	/** Initialize your data structure here. */
//	public MyQueue() {
//		in = new ArrayDeque<>();
//		out = new ArrayDeque<>();
//	}
//
//	/** Push element x to the back of queue. */
//	public void push(int x) {
//		in.addFirst(x);
//	}
//
//	/** Removes the element from in front of queue and returns that element. */
//	public int pop() {
//		if (out.isEmpty()) {
//			while (!in.isEmpty()) {
//				out.addFirst(in.pollFirst());
//			}
//		}
//		return out.pollFirst();
//	}
//
//	/** Get the front element. */
//	public int peek() {
//		if (out.isEmpty()) {
//			while (!in.isEmpty()) {
//				out.addFirst(in.pollFirst());
//			}
//		}
//		return out.peekFirst();
//	}
//
//	/** Returns whether the queue is empty. */
//	public boolean empty() {
//		return in.isEmpty() && out.isEmpty();
//	}
//}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */