package ReverseLinkedList2;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null) {
			return head;
		}

		if (left == right) {
			return head;
		}

		ListNode dummyHead = new ListNode();
		dummyHead.next = head;

		ListNode leftPrev = dummyHead;
		ListNode leftNode = head;
		while (left > 1) {
			leftNode = leftNode.next;
			leftPrev = leftPrev.next;
			left--;
		}

		ListNode rightPrev = dummyHead;
		ListNode rightNode = head;

		while (right > 1) {
			rightNode = rightNode.next;
			rightPrev = rightPrev.next;
		}

		return head;
	}
}