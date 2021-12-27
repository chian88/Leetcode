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
	Map<Node, Node> visited = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		if (visited.containsKey(head)) {
			return visited.get(head);
		}

		Node newNode = new Node(head.val);
		newNode.next = null;
		newNode.random = null;

		visited.put(head, newNode);

		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);

		return newNode;
	}
}