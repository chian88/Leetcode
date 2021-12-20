package SwapNodesInPairs;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;


		ListNode prev = dummyHead;
		ListNode curr = head;


		while (curr.next != null) {
			ListNode next = curr.next;
			ListNode temp = next.next;

			prev.next = next;
			next.next = curr;
			curr.next = temp;
			prev = curr;
			curr = temp;
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		Solution test = new Solution();
		test.swapPairs(one);
	}

}