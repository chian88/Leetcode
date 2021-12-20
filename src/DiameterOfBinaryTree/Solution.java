package DiameterOfBinaryTree;
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
    	public int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		diameterOfBinaryTreeHelper(root);
		return diameter;
	}

	private int diameterOfBinaryTreeHelper(TreeNode node) {
		if (node == null) return 0;

		int left = diameterOfBinaryTreeHelper(node.left);
		int right = diameterOfBinaryTreeHelper(node.right);

		diameter = Math.max(left + right, diameter);

		return Math.max(left, right) + 1;
	}


	public static void main(String[] args) {
		TreeNode eight = new TreeNode(8);
		TreeNode four = new TreeNode(4, eight, null);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2, four, five);
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1, two, three);
	}
}