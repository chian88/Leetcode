package OddEvenLinkedList;
import java.util.*;

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode oddEvenList(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode oddIter = odd;
		ListNode even = head.next;
		ListNode evenIter = even;

		while (evenIter != null && evenIter.next != null) {
			oddIter.next = evenIter.next;
			oddIter = oddIter.next;
			evenIter.next = oddIter.next;
			evenIter = evenIter.next;
		}
		oddIter.next = even;

		return odd;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode seven = new ListNode(7);
		ListNode eight = new ListNode(8);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
//		seven.next = eight;

		test.oddEvenList(null);
	}
}