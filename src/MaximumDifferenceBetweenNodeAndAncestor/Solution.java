package MaximumDifferenceBetweenNodeAndAncestor;
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
	public int maxAncestorDiff(TreeNode root) {
		return recursion(root, root.val, root.val);
	}

	int recursion(TreeNode node, int max, int min) {

		int diff = Math.max(Math.abs(max - node.val), Math.abs(min - node.val));

		max = Math.max(node.val, max);
		min = Math.min(node.val, min);
		if (node.left != null) {
			diff = Math.max(diff, recursion(node.left, max, min));
		}

		if (node.right != null) {
			diff = Math.max(diff, recursion(node.right, max, min));
		}

		return diff;
	}

	public static void main(String[] args) {
		TreeNode eight = new TreeNode(8);
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		eight.left = three;
		three.left = one;
		three.right = six;

		Solution test = new Solution();
		test.maxAncestorDiff(eight);
	}
}