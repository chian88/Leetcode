package ConvertBinarySearchTreeToSortedDoublyLinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
	public Node treeToDoublyList(Node root) {
		recurse(root);
		Node head = findMostLeft(root);
		Node tail = findMostRight(root);
		head.left = tail;
		tail.right = head;
		return head;
	}

	void recurse(Node root) {
		if (root.left != null) {
			Node mostRight = findMostRight(root.left);

			recurse(root.left);

			root.left = mostRight;
			mostRight.right = root;
		}

		if (root.right != null) {
			Node mostLeft = findMostLeft(root.right);
			recurse(root.right);
			root.right = mostLeft;
			mostLeft.left = root;
		}

	}

	Node findMostLeft(Node root) {
		if (root.left != null) {
			return findMostLeft(root.left);
		}

		return root;
	}


	Node findMostRight(Node root) {
		if (root.right != null) {
			return findMostRight(root.right);
		}

		return root;
	}

	public static void main(String[] args) {
		Node seven = new Node(7);
		Node three = new Node(3);
		Node one = new Node(1);
		Node five = new Node(5);
		Node four = new Node(4);
		Node six = new Node(6);
		Node ten = new Node(10);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node twelve = new Node(12);
		Node thirteen = new Node(13);

		seven.left = three;
		three.left = one;
		three.right = five;
		five.left = four;
		five.right = six;
		seven.right = ten;
		ten.left = eight;
		eight.right = nine;
		ten.right = twelve;
		twelve.right = thirteen;
		Solution test = new Solution();
		test.treeToDoublyList(seven);



	}
}