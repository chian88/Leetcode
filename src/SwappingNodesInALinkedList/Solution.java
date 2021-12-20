package SwappingNodesInALinkedList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


class Solution {
	public ListNode swapPairs(ListNode head) {
		head = swapHead(head);

		return head;
	}

	ListNode swapHead(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tail = head.next;
		ListNode beyond = tail.next;
		tail.next = head;
		head.next = swapHead(beyond);
		return tail;

	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
//		four.next = five;
		Solution test = new Solution();
		test.swapPairs(one);
	}
}

//class Solution {
//	public ListNode swapNodes(ListNode head, int k) {
//		ListNode dummyHead = new ListNode();
//		dummyHead.next = head;
//		ListNode front = dummyHead;
//		while (k > 0) {
//			front = front.next;
//			k--;
//		}
//
//		ListNode tail = front;
//		ListNode back = dummyHead;
//
//		while (tail != null) {
//			back = back.next;
//			tail = tail.next;
//		}
//
//		ListNode iter = dummyHead;
//		ListNode frontNext = front.next;
//		ListNode backNext = back.next;
//		while (iter != null) {
//			if (iter.next == front) {
//				iter.next = back;
//				back.next = frontNext;
//			} else if (iter.next == back) {
//				iter.next = front;
//				front.next = backNext;
//			}
//			iter = iter.next;
//		}
//
//		return dummyHead.next;
//	}
//}