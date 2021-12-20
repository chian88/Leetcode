package NaryTreePostorderTraversal;
import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
	public List<Integer> postorder(Node root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null) {
			return res;
		}

		Stack<Node> stack = new Stack();

		stack.add(root);

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			res.addFirst(node.val);
			for (Node child : node.children) {
				if (child != null) {
					stack.add(child);
				}
			}
		}

		return res;
	}
}

// recursion.
//class Solution {
//	public List<Integer> postorder(Node root) {
//		List<Integer> res = new ArrayList<>();
//		if (root == null) {
//			return res;
//		}
//		recursion(root, res);
//
//		return res;
//	}
//
//	void recursion(Node node, List<Integer> res) {
//		for (int i = 0; i < node.children.size(); i++) {
//			recursion(node.children.get(i), res);
//		}
//
//		res.add(node.val);
//	}
//}