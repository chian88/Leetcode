package BoundaryOfBinaryTree;
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
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> leftBoundary = new ArrayList<>();
		if (root.left != null) {
			findLeftBoundary(root.left, leftBoundary);
		}

		List<Integer> leaves = new ArrayList<>();

		if (root.left != null) {
			findLeaves(root.left, leaves);
		}

		if (root.right != null) {
			findLeaves(root.right, leaves);
		}

		List<Integer> rightBoundary = new ArrayList<>();
		if (root.right != null) {
			findRightBound(root.right, rightBoundary);
		}

		List<Integer> res = new ArrayList<>();
		res.add(root.val);
		res.addAll(leftBoundary);
		res.addAll(leaves);
		Collections.reverse(rightBoundary);
		res.addAll(rightBoundary);

		return res;
	}

	void findRightBound(TreeNode node, List<Integer> rightBoundary) {
		if (node.left != null || node.right != null) {
			rightBoundary.add(node.val);
		}

		if (node.right != null) {
			findRightBound(node.right, rightBoundary);
		} else if (node.left != null) {
			findRightBound(node.left, rightBoundary);
		}
	}

	void findLeaves(TreeNode node, List<Integer> leaves) {
		if (node.left == null && node.right == null) {
			leaves.add(node.val);
		} else {
			if (node.left != null) {
				findLeaves(node.left, leaves);
			}
			if (node.right != null) {
				findLeaves(node.right, leaves);
			}
		}
	}

	void findLeftBoundary(TreeNode node , List<Integer> leftBoundary ) {
		if (node.left != null || node.right != null) {
			leftBoundary.add(node.val);
		}

		if (node.left != null) {
			findLeftBoundary(node.left, leftBoundary);
		} else if (node.right != null) {
			findLeftBoundary(node.right, leftBoundary);
		}
	}
}