package ValidateBinarySearchTree;
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
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return recursion(root, null, null);

	}

	boolean recursion(TreeNode root, Integer lowerBound, Integer upperBound) {
		if (root == null) {
			return true;
		}

		if ( (lowerBound != null && root.val <= lowerBound) || (upperBound != null && root.val >= upperBound)){
			return false;
		}

		boolean leftSub = recursion(root.left, lowerBound, root.val);
		if (!leftSub) {
			return false;
		}
		boolean rightSub = recursion(root.right, root.val, upperBound);
		if (!rightSub) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(Integer.MAX_VALUE);
		TreeNode next = new TreeNode(Integer.MAX_VALUE);

		root.left = next;
		Solution test = new Solution();
		test.isValidBST(root);
	}
}