package ReverseNodeInKGroup;


import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {

		if (k == 1) return head;
		int start = 0;

		int len = findLength(head);

		int multiple = len / k;

		for (int i = 0; i < multiple; i++) {
			head = reverseKGroupHelper(head, k, start);
			start += k;
		}



		return head;
	}

	int findLength(ListNode head) {
		int len = 0;

		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
	}

	ListNode reverseKGroupHelper(ListNode head, int k, int start) {
		if (k <= 1) return head;
		if (k == 2) {
			// special case
			if (start == 0) {
				ListNode curr = head;
				ListNode last = curr.next;
				ListNode beyond = last.next;

				head = last;
				curr.next = beyond;
				last.next = curr;


			} else {
				ListNode prev = head;
				int iter = start - 1;


				while (prev != null && iter > 0) {
					prev = prev.next;
					iter -= 1;
				}



				ListNode curr = prev.next;

				ListNode last = prev;

				iter = k ;
				while (last != null &&  iter > 0) {
					last = last.next;
					iter -= 1;
				}


				ListNode beyond = last.next;

				prev.next = last;
				last.next = curr;
				curr.next = beyond;

			}

			return head;
		} else {
			ListNode prev = head;

			int iter = start - 1;

			while (prev != null && iter > 0) {
				prev = prev.next;
				iter -= 1;
			}



			if (start == 0) {
				ListNode curr = head;
				ListNode next = curr.next;


				ListNode prev2 = curr;

				iter = k - 2;
				while (prev2 != null &&  iter > 0) {
					prev2 = prev2.next;
					iter -= 1;
				}



				ListNode last = prev2.next;
				ListNode beyond = null;
				if (last != null) {
					beyond = last.next;
				}

				head = last;
				last.next = next;
				prev2.next = curr;
				curr.next = beyond;

				return reverseKGroupHelper(head, k - 2, start + 1);
			} else {
				ListNode curr = prev.next;
				ListNode next = prev.next.next;


				ListNode prev2 = prev;

				iter = k - 1;
				while (prev2 != null &&  iter > 0) {
					prev2 = prev2.next;
					iter -= 1;
				}


				ListNode last = prev2.next;
				ListNode beyond = null;
				if (prev2.next != null) {
					beyond = prev2.next.next;
				}


				prev.next = last;
				prev2.next = curr;
				curr.next = beyond;
				last.next = next;

				return reverseKGroupHelper(head, k - 2, start + 1);
			}

		}
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
		one.next = two;
		two.next = three;
		three.next = four;
//		four.next = five;
//		five.next = six;
//		six.next = seven;
//		seven.next = eight;
//		eight.next = nine;
		test.reverseKGroup(one, 4);
	}
}