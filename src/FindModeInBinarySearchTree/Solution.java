package FindModeInBinarySearchTree;

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
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> counter = new HashMap<>();
		recurse(root, counter);

		int max = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			max = Math.max(max, entry.getValue());
		}
		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			if (entry.getValue() == max) {
				res.add(entry.getKey());
			}
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}

		return result;
	}

	void recurse(TreeNode root, Map<Integer, Integer> counter) {
		counter.put(root.val, counter.getOrDefault(root.val, 0) + 1);
		if (root.left != null) {
			recurse(root.left, counter);
		}

		if (root.right != null) {
			recurse(root.right, counter);
		}

	}
}