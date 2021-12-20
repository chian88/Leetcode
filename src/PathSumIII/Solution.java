package PathSumIII;

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
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		return recurse(root, targetSum, prefixSum, 0);

	}

	int recurse(TreeNode root, int targetSum, Map<Integer, Integer> prefixSum, int cummSum) {
		int output = 0;
		cummSum += root.val;
		if (cummSum == targetSum) {
			output += 1;
		}

		if (prefixSum.containsKey(cummSum - targetSum)) {
			output += prefixSum.get(cummSum - targetSum);
		}

		prefixSum.put(cummSum, prefixSum.getOrDefault(cummSum, 0) + 1);

		if (root.left != null) {
			output += recurse(root.left, targetSum, prefixSum, cummSum);
		}

		if (root.right != null) {
			output += recurse(root.right, targetSum, prefixSum, cummSum);
		}

		prefixSum.put(cummSum, prefixSum.getOrDefault(cummSum, 0) - 1);
		return output;
	}


}