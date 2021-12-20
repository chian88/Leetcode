package CheckCompletenessOfABinaryTree;
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
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		boolean firstNullChild = false;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.left != null && firstNullChild) {
				return false;
			} else if (node.left != null) {
				q.add(node.left);
			} else {
				firstNullChild = true;
			}

			if (node.right != null && firstNullChild) {
				return false;
			} else if (node.right != null) {
				q.add(node.right);
			} else {
				firstNullChild = true;
			}
		}

		return true;
	}
}