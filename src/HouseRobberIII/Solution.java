package HouseRobberIII;
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
	public int rob(TreeNode root) {
		Map<TreeNode, Integer> dp = new HashMap<>();
		return recurse(root, dp);
	}

	int recurse(TreeNode root, Map<TreeNode, Integer> dp) {
		if (root == null) return 0;

		if (dp.containsKey(root)) {
			return dp.get(root);
		}
		int nextLevel = 0;
		int nextNextLevel = 0;
		if (root.left != null) {
			nextLevel += recurse(root.left, dp);
			if (root.left.left != null) nextNextLevel += recurse(root.left.left, dp);
			if (root.left.right != null) nextNextLevel += recurse(root.left.right, dp);
		}
		if (root.right != null) {
			nextLevel += recurse(root.right, dp);
			if (root.right.left != null) nextNextLevel += recurse(root.right.left, dp);
			if (root.right.right != null) nextNextLevel += recurse(root.right.right, dp);
		}
		int ans = Math.max(root.val + nextNextLevel , nextLevel);
		dp.put(root, ans);
		return ans;
	}
}