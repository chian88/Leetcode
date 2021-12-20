package PalindromeLinkedList;
import java.util.*;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
	public boolean isPalindrome(ListNode head) {



		ListNode tail = null;
		ListNode curr = new ListNode(head.val);
		curr.next = head.next;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = tail;
			tail = curr;
			curr = temp;
		}


		while (tail != null && head != null) {
			if (head.val != tail.val) {
				return false;
			}
			tail = tail.next;
			head = head.next;
		}

		return tail == null && head == null;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode one1 = new ListNode(1);
		ListNode two1 = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode two2 = new ListNode(2);
		ListNode one2 = new ListNode(1);
		one1.next = two1;
		two1.next = three;
		three.next = two2;
		two2.next = one2;

		test.isPalindrome(one1);
	}
}