package FlattenMultilevelDoublyLinkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
	public Node flatten(Node head) {
		recursion(head, null);
		return head;
	}

	void recursion(Node node, Node parent) {
		if (node == null) {
			return;
		}

		Node temp = node.next;
		if (node.child != null) {
			node.next = node.child;
			recursion(node.child, node);
			node.child = null;
			Node parent2 = node.next;
			while (parent2.next != null) {
				parent2 = parent2.next;
			}
			parent2.next = temp;
			recursion(temp, parent2);
		} else {
			recursion(temp, node);

		}

		node.prev = parent;
	}

	public static void main(String[] args) {
		Node one = new Node();
		Node two = new Node();
		Node three = new Node();
		Node four = new Node();
		Node five = new Node();
		Node six = new Node();
		Node seven = new Node();
		Node eight = new Node();
		Node nine = new Node();
		Node ten = new Node();
		Node elevent = new Node();
		Node twelve = new Node();

		one.val = 1;
		one.next = two;
		two.prev = one;
		two.next = three;
		two.val = 2;
		three.prev = two;
		three.val = 3;
		three.next = four;
		four.val = 4;
		four.prev = three;
		four.next = five;
		five.val = 5;
		five.prev = four;
		five.next = six;
		six.val = 6;
		six.prev = five;
		three.child = seven;
		seven.next = eight;
		seven.val = 7;
		eight.prev = seven;
		eight.val = 8;
		eight.next = nine;
		nine.prev = eight;
		nine.val = 9;
		nine.next = ten;
		ten.val = 10;
		ten.prev = nine;
		eight.child = elevent;
		elevent.val = 11;
		elevent.next = twelve;
		twelve.prev = elevent;
		twelve.val = 12;

		Solution test = new Solution();
		test.flatten(one);
	}
}