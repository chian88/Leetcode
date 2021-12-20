package ReorderList;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public void reorderList(ListNode head) {
		int len = 0;

		ListNode iter = head;

		while (iter != null) {
			iter = iter.next;
			len++;
		}

		int mid = len / 2;

		if (len % 2 == 0) {
			mid--;
		}
		ListNode secondHalf = head;
		while (mid > 0) {
			secondHalf = secondHalf.next;
			mid--;
		}

		ListNode temp = secondHalf.next;
		secondHalf.next = null;
		secondHalf = temp;


		ListNode prev = null;

		while (secondHalf != null) {
			ListNode tempo = secondHalf.next;
			secondHalf.next = prev;
			prev = secondHalf;
			secondHalf = tempo;
		}

		secondHalf = prev;

		iter = head;
		boolean tiktok = true;
		temp = null;
		while (iter != null) {
			if (tiktok) {
				temp = iter.next;
				iter.next = secondHalf;
				if (secondHalf != null) {
					secondHalf = secondHalf.next;
				}

				iter = iter.next;
			} else {
				ListNode temp2 = temp;
				temp = iter.next;
				iter.next = temp2;
				iter = iter.next;

			}

			tiktok = !tiktok;
		}


		int x = 1;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
//		ListNode seven = new ListNode(7);
//		ListNode eight = new ListNode(8);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
//		six.next = seven;
//		seven.next = eight;

		Solution test = new Solution();
		test.reorderList(one);
//		ListNode one = new ListNode(1);

	}
}