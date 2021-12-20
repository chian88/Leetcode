package RemoveNthNodeFromEndOfList;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = null;
		int nIter = n;
		while (nIter > 0) {
			fast = fast.next;
			nIter--;
		}
		while (fast != null ) {

			fast = fast.next;
			slow = slow == null ? head : slow.next;
		}

		if (slow == null) {
			return head.next;
		}

		slow.next = slow.next == null ? null : slow.next.next;

		return head;

	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		one.next = two;
//		two.next = three;
		Solution test = new Solution();
		test.removeNthFromEnd(one, 2);
	}
}


//class Solution {
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//
//		int len = 0;
//		ListNode arrow = head;
//
//		while (arrow != null) {
//			len += 1;
//			arrow = arrow.next;
//		}
//
//		if (n == len) {
//			// remove head
//			return head.next;
//		} else {
//			// standard
//
//			int k = len - n;
//
//			arrow = head;
//
//			while (k > 1) {
//				arrow = arrow.next;
//				k--;
//			}
//
//			arrow.next = arrow.next.next;
//
//			return head;
//		}
//
//	}
//}