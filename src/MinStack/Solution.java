package MinStack;
import java.util.*;


class MinStack {
	Stack<int[]> stack;
	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new int[]{val, val});
		} else {
			stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}
}

//class MinStack {
//    Deque<int[]> stack;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new ArrayDeque<>();
//    }
//
//    public void push(int val) {
//        if (stack.isEmpty()) {
//            stack.push(new int[] {val, val});
//        } else {
//            int currentMin = stack.peek()[1];
//            stack.push(new int[]{val, Math.min(currentMin, val)});
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek()[0];
//    }
//
//    public int getMin() {
//        return stack.peek()[1];
//    }
//
//    public static void main(String[] args) {
//        MinStack test = new MinStack();
//        test.push(-2);
//        test.push(0);
//        test.push(-3);
//        System.out.println(test.getMin());
//        test.pop();
//        test.top();
//        test.getMin();
//    }
//}