package PathSum;
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
	private int targetSum;
	public boolean hasPathSum(TreeNode root, int targetSum) {
		this.targetSum = targetSum;
		if (root == null) {
			return false;
		}
		return recursion(root, 0);
	}

	boolean recursion(TreeNode node, int currSum) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null) {
			return (currSum  + node.val) == targetSum;
		}
		return recursion(node.left, currSum + node.val) || recursion(node.right, currSum + node.val);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		one.left = two;
		test.hasPathSum(one, 2);
	}
}