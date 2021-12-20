package CopyListWithRandomNumber;
import java.util.*;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}


class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) return null;
		List<Integer> randomOrder = new ArrayList<>();
		Node res =  new Node(head.val);
		randomOrder.add(countRandomOrder(head, head.random));
		Node resIter = res;
		Node headIter = head;
		while (headIter.next != null) {
			resIter.next = new Node(headIter.next.val);
			randomOrder.add(countRandomOrder(head, headIter.next.random ));
			headIter = headIter.next;
			resIter = resIter.next;

		}
		resIter = res;
		Iterator<Integer> randomOrderIter = randomOrder.iterator();
		while (resIter != null) {
			int order = randomOrderIter.next();
			resIter.random = fetchNode(res, order);
			resIter = resIter.next;
		}



		return res;
	}

	Node fetchNode(Node head, int order) {
		if (order == -1) return null;

		while (order > 0) {
			head = head.next;
			order -= 1;
		}

		return head;
	}

	int countRandomOrder(Node head, Node random) {
		int order = 0;
		if (random == null) return -1;
		while (head != random) {
			order += 1;
			head = head.next;
		}

		return order;
	}

	public static void main(String[] args) {
		Node seven = new Node(7);
		Node thirteen = new Node(13);
		Node eleven = new Node(11);
		Node ten = new Node(10);
		Node one = new Node(1);

		seven.random = null;
		seven.next = thirteen;
		thirteen.random = seven;
		thirteen.next = eleven;
		eleven.next = ten;
		eleven.random = one;
		ten.next = one;
		ten.random = eleven;
		one.next = null;
		one.random = seven;

		Solution test = new Solution();
		test.copyRandomList(seven);
	}
}