package removeDuplicates;
import java.util.*;
import java.util.ArrayDeque;

class Solution {

	// keep counter


	// stack
	public static String removeDuplicates(String s, int k) {
		Deque<Integer> counter = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			if (i == 0 || sb.charAt(i) !=  sb.charAt(i - 1)) {
				// push a 1 into the stack.
				counter.addFirst(1);
			} else {
				int prev = counter.removeFirst();
				counter.addFirst(prev+1);
				if (counter.peekFirst() == k) {
					sb.delete(i - k + 1, i + 1);
					counter.removeFirst();
					i = i - k;
				}
			}
		}
		return sb.toString();
	}


}