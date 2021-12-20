package ClosestBinarySearchTreeValue;
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
	int res;
	double minDiff;
	double target;
	public int closestValue(TreeNode root, double target) {
		res = root.val;
		minDiff = Math.abs(target - root.val);
		this.target = target;
		recursion(root);
		return res;
	}

	void recursion(TreeNode node) {
		if (node == null) {
			return;
		}
		double diff = Math.abs(target - node.val);
		if (diff < minDiff) {
			res = node.val;
			minDiff = diff;
		}

		if (target < node.val) {
			recursion(node.left);
		} else {
			recursion(node.right);
		}
	}
}