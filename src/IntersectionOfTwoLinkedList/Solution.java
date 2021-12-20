package IntersectionOfTwoLinkedList;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = 0, len2 = 0;
		ListNode iterA = headA;
		while (iterA != null) {
			iterA = iterA.next;
			len1++;
		}

		ListNode iterB = headB;
		while (iterB != null) {
			iterB = iterB.next;
			len2++;
		}
		iterA = headA;
		iterB = headB;
		if (len1 < len2) {

			int diff = len2 - len1;
			while (diff > 0) {
				iterB = iterB.next;
				diff--;
			}

		} else {

			int diff = len1 - len2;

			while (diff > 0) {
				iterA = iterA.next;
				diff--;
			}
		}

		while (iterA != null && iterB != null) {
			if (iterA == iterB) {
				return iterA;
			}
			iterA = iterA.next;
			iterB = iterB.next;
		}

		return null;
	}

	public static void main(String[] args) {
		ListNode four = new ListNode(4);
		ListNode one = new ListNode(1);
		ListNode eight = new ListNode(8);
		ListNode four2 = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode five1 = new ListNode(5);
		ListNode six = new ListNode(6);

		four.next = one;
		one.next = eight;
		eight.next = four2;
		four2.next = five;


		five1.next = six;
		six.next = one;

		Solution test = new Solution();
		test.getIntersectionNode(four, five1);
	}
}

 // hashset
//public class Solution {
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		Set<ListNode> a = new HashSet<>();
//
//		while (headA != null) {
//			a.add(headA);
//			headA = headA.next;
//		}
//
//		while (headB != null) {
//			if (a.contains(headB)) {
//				return headB;
//			}
//
//			headB = headB.next;
//		}
//
//		return null;
//	}
//}