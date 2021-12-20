package DistributeCoinsInBinaryTree;

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
	public int distributeCoins(TreeNode root) {
		int count = recursion(root, null);
		return count;
	}

	int recursion(TreeNode node, TreeNode parent) {
		int count = 0;
		if (node.left != null) {
			count += recursion(node.left, node);
		}

		if (node.right != null) {
			count += recursion(node.right, node);
		}
		if (node.val <= 0) {
			parent.val -= Math.abs(node.val) + 1;
			count += Math.abs(node.val) + 1;
			node.val = 1;

		} else if (node.val > 1) {
			count += node.val - 1;
			parent.val += node.val - 1;
			node.val = 1;
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode three = new TreeNode(0);
		TreeNode two = new TreeNode(0);
		TreeNode four = new TreeNode(3);
		root.left = two;
		root.right = three;
		two.right = four;

		Solution test = new Solution();
		test.distributeCoins(root);
	}
}