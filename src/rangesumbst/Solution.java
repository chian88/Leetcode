package rangesumbst;
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
	public int rangeSumBST(TreeNode root, int low, int high) {
		int sum = rangeSumBSTHelper(root, low, high);

		return sum;
	}

	private int rangeSumBSTHelper(TreeNode root, int low, int high) {
		if (root == null) return 0;

		int runningSum = 0;
		if (root.val >= low && root.val <= high) {
			runningSum += root.val;
		}

		if (root.val >= low) {
			runningSum += rangeSumBSTHelper(root.left, low, high);
		}

		if (root.val <= high) {
			runningSum += rangeSumBSTHelper(root.right, low, high);
		}

		return runningSum;

	}

	public static void main(String[] args) {

	}
}