package SortList;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = getMid(head);

		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		return mergeList(left, right);
	}

	ListNode mergeList(ListNode left, ListNode right) {
		ListNode dummyHead = new ListNode();

		ListNode iter = dummyHead;

		while (left != null && right != null) {
			if (left.val < right.val) {
				iter.next = left;
				left = left.next;

			} else {
				iter.next = right;
				right = right.next;
			}
			iter = iter.next;
		}

		if (left != null) {
			iter.next = left;
		}

		if (right != null) {
			iter.next = right;
		}

		return dummyHead.next;
	}

	ListNode getMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = null;

		while (fast != null && fast.next != null) {
			slow = slow == null ? head : slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;

		return mid;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(10);
		ListNode one2 = new ListNode(1);
		ListNode one3 = new ListNode(60);
		ListNode one4 = new ListNode(30);
		ListNode one5 = new ListNode(5);
		one.next = one2;
		one2.next = one3;
		one3.next = one4;
		one4.next = one5;

		Solution test = new Solution();
		test.sortList(one);
	}
}