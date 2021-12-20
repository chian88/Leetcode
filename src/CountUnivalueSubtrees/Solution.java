package CountUnivalueSubtrees;
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

class Structure {
	boolean uniValue;
	int count;
	int val;

	Structure(boolean uniValue, int count, int val) {
		this.uniValue = uniValue;
		this.count = count;
		this.val = val;
	}
}
class Solution {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return recursion(root).count;

	}

	Structure recursion(TreeNode node) {
		if (node == null) {
			return null;
		}

		Structure left = recursion(node.left);
		Structure right = recursion(node.right);

		if (left != null && right != null) {
			if (left.uniValue && right.uniValue && left.val == node.val && right.val == node.val) {
				return new Structure(true, left.count + right.count + 1, node.val);
			} else {
				return new Structure(false, left.count + right.count, node.val);
			}
		} else if (left != null) {
			if (left.uniValue && left.val == node.val) {
				return new Structure(true, left.count + 1, left.val);
			} else {
				return new Structure(false, left.count, left.val);
			}
		} else if (right != null) {
			if (right.uniValue && right.val == node.val) {
				return new Structure(true, right.count + 1, right.val);
			} else {
				return new Structure(false, right.count, right.val);
			}
		}

		return new Structure(true, 1, node.val);
	}
}
















