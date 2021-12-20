package FindLeavesOfBinaryTree;
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
	public List<List<Integer>> findLeaves(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> res = new ArrayList<>();
		recurse(root, res);
		return res;
	}

	int recurse(TreeNode root, List<List<Integer>> res) {
		if (root.left == null && root.right == null) {
			if (res.size() == 0) {
				List<Integer> arr = new ArrayList<>();
				arr.add(root.val);
				res.add(arr);
			} else {
				res.get(0).add(root.val);
			}
			return 1;
		}

		int left = -1;
		if (root.left != null) {
			left = recurse(root.left, res);
		}

		int right = -1;
		if (root.right != null) {
			right = recurse(root.right, res);
		}

		int currIdx = Math.max(left, right);

		if (res.size() <= currIdx) {
			List<Integer> arr = new ArrayList<>();
			arr.add(root.val);
			res.add(arr);
		} else {
			res.get(currIdx).add(root.val);
		}

		return currIdx + 1;
	}
}