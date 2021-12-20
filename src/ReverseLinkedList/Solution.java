package ReverseLinkedList;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		return recursion(head, null);
	}

	ListNode recursion(ListNode head, ListNode prev) {
		if (head.next == null) {
			head.next = prev;
			return head;
		}
		ListNode temp = head.next;
		head.next = prev;
		return recursion(temp, head);
	}
}