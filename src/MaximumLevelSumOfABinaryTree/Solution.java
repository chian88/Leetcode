package MaximumLevelSumOfABinaryTree;
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
	public int maxLevelSum(TreeNode root) {
		int res = 0;
		int max = Integer.MIN_VALUE;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;

		while (!q.isEmpty()) {
			int layerSize = q.size();
			int sum = 0;
			while (layerSize > 0) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}

				layerSize--;
			}

			if (sum > max) {
				max = sum;
				res = level;
			}

			level++;
		}

		return res;
	}
}