package BinaryTreePruning;
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
	public TreeNode pruneTree(TreeNode root) {
		boolean gotOne = recursion(root);
		if (!gotOne) {
			return null;
		}

		return root;
	}

	boolean recursion(TreeNode node) {
		if (node == null) {
			return true;
		}

		boolean gotOneMain = false;

		if (node.val == 1) {
			gotOneMain = true;
		}

		if (node.left != null) {
			boolean gotOne = recursion(node.left);

			if (!gotOne) {
				node.left = null;
			} else {
				gotOneMain = true;
			}
		}

		if (node.right != null) {
			boolean gotOne = recursion(node.right);

			if (!gotOne) {
				node.right = null;
			} else {
				gotOneMain = true;
			}
		}

		return gotOneMain;
	}
}