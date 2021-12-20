package PopulatingNextRightPointersInEachNode2;
import java.util.*;

// Definition or a Node.
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
}

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