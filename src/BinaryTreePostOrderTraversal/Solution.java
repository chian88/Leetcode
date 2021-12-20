package BinaryTreePostOrderTraversal;
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
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		recursion(root, res);
		return res;
	}

	void recursion(TreeNode node, List<Integer> res) {
		if (node.left != null) {
			recursion(node.left, res);
		}

		if (node.right != null) {
			recursion(node.right, res);
		}

		res.add(node.val);
	}
}