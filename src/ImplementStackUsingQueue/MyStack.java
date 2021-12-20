package ImplementStackUsingQueue;
import ContiguousArray.Solution;

import java.util.*;

class MyStack {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	public MyStack() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int x) {
		q1.offer(x);
	}

	public int pop() {
		if(q1.isEmpty()) {
			while (q2.size() > 1) {
				q1.offer(q2.poll());
			}
			return q2.poll();
		} else {
			while (q1.size() > 1) {
				q2.offer(q1.poll());
			}

			return q1.poll();
		}
	}

	public int top() {
		if(q1.isEmpty()) {
			while (q2.size() > 1) {
				q1.offer(q2.poll());
			}

			int res = q2.poll();
			q1.offer(res);
			return res;
		} else {
			while (q1.size() > 1) {
				q2.offer(q1.poll());
			}
			int res = q1.poll();
			q2.offer(res);
			return res;
		}
	}

	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}

	public static void main(String[] args) {
		MyStack test = new MyStack();
		test.push(1);
		test.push(2);
		test.push(3);
		test.top();
		test.pop();
		test.top();
		test.pop();
		test.top();
		test.empty();
		test.pop();
		test.empty();
	}
}