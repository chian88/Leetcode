package NaryTreeLevelOrderTraversal;
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
	public List<List<Integer>> levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();

		if (root == null) {
			return Collections.emptyList();
		}

		q.add(root);
		List<List<Integer>> res = new ArrayList<>();
 		while (!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> level = new ArrayList<>();
			while (levelSize > 0) {
				Node curr = q.poll();
				level.add(curr.val);
				for (Node child : curr.children) {
					if (child != null) {
						q.add(child);
					}

				}

				levelSize--;
			}

			res.add(level);
		}

		 return res;
	}
}