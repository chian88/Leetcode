package RotateList;
import java.util.*;

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int n = 0;
		ListNode iter = head;
		while (iter != null) {
			n++;
			iter = iter.next;
		}

		k = k % n;

		ListNode tail = head;

		if (k == 0) {
			return head;
		}

		while (k > 0) {
			k--;
			tail = tail.next;
		}

		ListNode curr = head;
		while (tail.next != null) {
			curr = curr.next;
			tail = tail.next;
		}
		ListNode temp = head;
		head = curr.next;
		curr.next = null;
		tail.next = temp;

		return head;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
//		one.next = two;
//		two.next = three;
//		three.next = four;
//		four.next = five;
		Solution test = new Solution();
		test.rotateRight(one, 0);
	}
}