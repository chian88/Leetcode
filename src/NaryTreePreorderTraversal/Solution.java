package NaryTreePreorderTraversal;
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
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<Node> stack = new Stack();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			res.add(curr.val);

			for (int i = curr.children.size() - 1 ; i >= 0 ; i--) {
				Node child = curr.children.get(i);
				stack.add(child);
			}



		}
		return res;
	}
}


//class Solution {
//	public List<Integer> preorder(Node root) {
//		List<Integer> res = new ArrayList<>();
//		if (root == null) {
//			return res;
//		}
//		recursion(root, res);
//		return res;
//	}
//
//	void recursion(Node node, List<Integer> res) {
//		res.add(node.val);
//		for(int i = 0; i < node.children.size(); i++) {
//			recursion(node.children.get(i), res);
//		}
//	}
//
//}