package SumRootToLeafNumbers;
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
	public int sumNumbers(TreeNode root) {
		List<String> res = new ArrayList<>();
		recursion(root, res, "");
		int ans = 0;

		for (String num : res) {
			ans += Integer.parseInt(num);
		}

		return ans;
	}

	void recursion(TreeNode root, List<String> res, String curr) {
		curr = curr + String.valueOf(root.val);

		if (root.left == null && root.right == null) {
			res.add(curr);
			return;
		}

		if (root.left != null) {
			recursion(root.left, res, curr);
		}

		if (root.right != null) {
			recursion(root.right, res, curr);
		}

	}
}