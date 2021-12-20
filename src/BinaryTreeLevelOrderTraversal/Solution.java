package BinaryTreeLevelOrderTraversal;
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> row = new ArrayList<>();
			while (levelSize > 0) {
				TreeNode curr = q.poll();
				row.add(curr.val);

				if (curr.left != null) {
					q.add(curr.left);
				}

				if (curr.right != null) {
					q.add(curr.right);
				}
				levelSize--;
			}

			res.add(row);
		}

		return res;
	}
}














//class Solution {
//	public List<List<Integer>> levelOrder(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();
//		if (root == null) return res;
//		Deque<TreeNode> q = new ArrayDeque<>();
//		q.addLast(root);
//
//		while (!q.isEmpty()) {
//			int levelSize = q.size();
//			List<Integer> levelRes = new ArrayList<>();
//			while (levelSize > 0) {
//				TreeNode curr = q.pollFirst();
//
//				levelRes.add(curr.val);
//
//				if (curr.left != null) {
//					q.addLast(curr.left);
//				}
//
//				if (curr.right != null) {
//					q.addLast(curr.right);
//				}
//
//
//
//				levelSize--;
//			}
//
//			res.add(levelRes);
//		}
//
//		return res;
//	}
//}