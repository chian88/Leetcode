package MergeTwoSortedList;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode iter = dummyHead;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				iter.next = list1;
				list1 = list1.next;
			} else {
				iter.next = list2;
				list2 = list2.next;
			}

			iter = iter.next;
		}

		if (list1 != null) {
			iter.next = list1;
		} else if (list2 != null) {
			iter.next = list2;
		}

		return dummyHead.next;
	}

//	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//		if (list1 == null) {
//			return list2;
//		} else if (list2 == null) {
//			return list1;
//		}
//
//		if (list1.val < list2.val) {
//			list1.next = mergeTwoLists(list1.next, list2);
//			return list1;
//		} else {
//			list2.next = mergeTwoLists(list1, list2.next);
//			return list2;
//		}
//
//
//	}



	public static void main(String[] args) {
		ListNode five = new ListNode(5);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = four;

		Solution test = new Solution();
		test.mergeTwoLists(five, one);
	}
}