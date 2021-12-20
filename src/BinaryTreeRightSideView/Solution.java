package BinaryTreeRightSideView;
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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		if (root == null) return res;
		q.addFirst(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();
			boolean first = true;
			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = q.removeLast();
				if (first) {
					res.add(curr.val);
					first = false;
				}
				if (curr.right != null) {
					q.addFirst(curr.right);
				}

				if (curr.left != null) {
					q.addFirst(curr.left);
				}
			}

		}


		return res;
	}


}