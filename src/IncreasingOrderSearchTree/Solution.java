package IncreasingOrderSearchTree;

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
	public TreeNode increasingBST(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		if (root == null) {
			return root;
		}
		recursion(root, inorder);

		TreeNode ans = new TreeNode(0);
		TreeNode iter = ans;

		for (int val : inorder) {
			iter.right = new TreeNode(val);
			iter = iter.right;
		}

		return ans.right;
	}

	void recursion(TreeNode node, List<Integer> inorder) {
		if (node.left != null) {
			recursion(node.left, inorder);
		}

		inorder.add(node.val);

		if (node.right != null) {
			recursion(node.right, inorder);
		}

	}
}