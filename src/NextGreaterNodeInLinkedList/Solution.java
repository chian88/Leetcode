package NextGreaterNodeInLinkedList;
import java.util.*;
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
	public int[] nextLargerNodes(ListNode head) {
		int n = 0;
		ListNode iter = head;
		while (iter != null) {
			iter = iter.next;
			n += 1;
		}

		int[] ans = new int[n];

		Deque<int[]> stack = new ArrayDeque<>();
		int idx = 0;
		while (head != null) {
			while(!stack.isEmpty() && stack.peekFirst()[1] < head.val ) {
				int[] item = stack.pollFirst();

				ans[item[0]] = head.val;
			}

			stack.addFirst(new int[]{idx, head.val});
			idx++;
			head = head.next;
		}

		return ans;
	}
}