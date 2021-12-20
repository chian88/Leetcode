package SplitLinkedListInParts;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode[] splitListToParts(ListNode head, int k) {
		int count = 0;

		ListNode iter = head;

		while (iter != null) {
			count++;
			iter = iter.next;
		}

		int normalCount = Math.max(1, count / k);
		int normalCountTemplate = normalCount;
		int extraCount = normalCount + 1;
		int extraCountTemplate = extraCount;
		int firstCount = 0;

		if (count > k) {
			firstCount = count % k;
		}


		ListNode[] res = new ListNode[k];

		int ptr = 0;
		iter = head;
		res[ptr] = iter;

		while (iter != null) {

			if (ptr < firstCount && extraCount > 1) {
				extraCount--;
				iter = iter.next;
			} else if (ptr < firstCount && extraCount == 1) {
				ListNode temp = iter.next;
				iter.next = null;
				if (ptr + 1 < res.length) {
					res[++ptr] = temp;
				}

				iter = temp;
				extraCount = extraCountTemplate;
			} else if (normalCount > 1) {
				normalCount--;
				iter = iter.next;
			} else if (normalCount == 1) {
				normalCount--;
				ListNode temp = iter.next;
				iter.next = null;
				if (ptr + 1 < res.length) {
					res[++ptr] = temp;
				}

				iter = temp;
				normalCount = normalCountTemplate;
			}

		}


		return res;
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
		ListNode nine = new ListNode(9);
		ListNode ten = new ListNode(10);
		one.next = two;
		two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next = six;
//		six.next = seven;
//		seven.next = eight;
//		eight.next = nine;
//		nine.next = ten;
		test.splitListToParts(one, 5);
	}
}