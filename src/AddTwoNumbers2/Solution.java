package AddTwoNumbers2;
import java.util.*;


   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = extractNumStr(l1);
		String num2 = extractNumStr(l2);

		String num3 = addTwoNumStr(num1,num2);

		ListNode ans = createListNode(num3);
		return ans;
	}

	ListNode createListNode(String num3) {

		int ptr = num3.length() - 1;
		ListNode curr = null;
		ListNode next = null;
		while (ptr >= 0) {
			curr = new ListNode(Integer.parseInt(String.valueOf(num3.charAt(ptr))));
			curr.next = next;
			next = curr;
			ptr--;
		}

		return curr;
	}

	String addTwoNumStr(String num1 , String num2) {
		int ptr1 = num1.length() - 1;
		int ptr2 = num2.length() - 1;

		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (ptr1 >= 0 && ptr2 >= 0) {
			int sum = (num1.charAt(ptr1) - '0') + (num2.charAt(ptr2) - '0') + carry;

			carry = sum / 10;
			res.insert(0, sum % 10);
			ptr1--;
			ptr2--;
		}

		while (ptr1 >= 0) {
			int sum = num1.charAt(ptr1) - '0' + carry;
			carry = sum / 10;
			res.insert(0, sum % 10);
			ptr1--;
		}

		while (ptr2 >= 0) {
			int sum = num2.charAt(ptr2) - '0' + carry;
			carry = sum / 10;
			res.insert(0, sum % 10);
			ptr2--;
		}

		if (carry > 0) {
			res.insert(0, carry);
		}

		return res.toString();
	}

	String extractNumStr(ListNode l1) {
		StringBuilder res = new StringBuilder();

		while (l1 != null) {
			res.append(l1.val);
			l1 = l1.next;

		}

		return res.toString();

	}


	public static void main(String[] args) {
		Solution test = new Solution();
		ListNode seven = new ListNode(7);

		ListNode two = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);

		ListNode zero = new ListNode(5);
		ListNode zero2 = new ListNode(6);
		ListNode zero3 = new ListNode(4);

//		zero.next = zero2;
//		zero2.next = zero3;

		seven.next = two;
		two.next = four;
		four.next = three;
		test.addTwoNumbers(zero, zero);
	}
}