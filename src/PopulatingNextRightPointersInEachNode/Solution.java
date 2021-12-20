package PopulatingNextRightPointersInEachNode;
import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
	public Node connect(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (root == null) {
			return null;
		}
		q.add(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();

			Node prev = null;
			while (levelSize > 0) {
				Node curr = q.poll();

				curr.next = prev;
				prev = curr;

				if (curr.right != null) {
					q.add(curr.right);
				}

				if (curr.left != null) {
					q.add(curr.left);
				}
				levelSize--;
			}
		}

		return root;
	}
}

//class Solution {
//	public Node connect(Node root) {
//		if (root == null) {
//			return null;
//		}
//		Deque<Node> q = new ArrayDeque<>();
//
//
//		q.addFirst(root);
//
//		while (!q.isEmpty()) {
//			int levelSize = q.size();
//
//			while (levelSize > 0) {
//				levelSize--;
//				Node curr = q.pollLast();
//
//				if (curr.left != null) {
//					q.addFirst(curr.left);
//				}
//
//				if (curr.right != null) {
//					q.addFirst(curr.right);
//				}
//
//
//				if (levelSize == 0) {
//					continue;
//				}
//				curr.next = q.peekLast();
//
//
//
//			}
//		}
//		return root;
//
//	}
//}