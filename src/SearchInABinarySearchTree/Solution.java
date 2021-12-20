package SearchInABinarySearchTree;
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
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		return recursion(root, val);
	}

	TreeNode recursion(TreeNode node, int val) {
		if (node == null) {
			return null;
		}
		if (node.val == val) {
			return node;
		} else if (val < node.val) {
			return recursion(node.left, val);
		} else {
			return recursion(node.right, val);
		}


	}
}