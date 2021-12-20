package MaximumDepthOfBinaryTree;
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

  // bottom up
  class Solution {
	  public int maxDepth(TreeNode root) {
		  if (root == null) {
			  return 0;
		  }
		  return recursion(root);

	  }

	  int recursion(TreeNode node) {
		  if (node == null) {
			  return 0;
		  }
		  int leftDepth = recursion(node.left);
		  int rightDepth = recursion(node.right);

		  return Math.max(leftDepth, rightDepth) + 1;
	  }
  }



  // top down
//class Solution {
//	public int maxDepth(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		return recursion(root, 1);
//
//	}
//
//	int recursion(TreeNode node, int depth) {
//		int leftDepth = depth;
//		if (node.left != null) {
//			leftDepth = recursion(node.left, depth + 1);
//		}
//		int rightDepth = depth;
//		if (node.right != null) {
//			rightDepth = recursion(node.right, depth + 1);
//		}
//
//		return Math.max(leftDepth, rightDepth);
//	}
//}