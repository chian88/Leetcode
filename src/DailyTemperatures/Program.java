package DailyTemperatures;
import java.util.*;

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack();
		int[] ans = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; ++i) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else  {
				while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
					int prevIdx = stack.pop();
					ans[prevIdx] = i - prevIdx;
				}

				stack.push(i);

			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
	}
}













//class Solution {
//	public static int[] dailyTemperatures(int[] temperatures) {
//		int[] stack = new int[temperatures.length];
//		int top = -1;
//		int[] ret = new int[temperatures.length];
//		for(int i = 0; i < temperatures.length; i++) {
//			while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
//				int idx = stack[top--];
//				ret[idx] = i - idx;
//			}
//			stack[++top] = i;
//		}
//		return ret;
//	}
//
//	public static void main(String[] args) {
//		dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
//	}
//}