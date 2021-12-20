package FindDuplicateSubtree;
import java.util.*;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new LinkedList<>();
		Map<String, Integer> counter = new HashMap<>();
		recursion(root, counter, res);

		return res;
	}

	String recursion(TreeNode node, Map<String, Integer> counter, List<TreeNode> res) {
		if (node == null) {
			return "#";
		}

		String serial = node.val + "," + recursion(node.left, counter, res) + "," + recursion(node.right, counter, res);
		counter.put(serial, counter.getOrDefault(serial, 0) + 1);

		if (counter.get(serial) == 2) {
			res.add(node);
		}
		return serial;
	}
}