package SameTree;

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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		} else if (p == null && q == null) {
			return true;
		}

		return recursion(p, q);
	}

	boolean recursion(TreeNode p , TreeNode q) {
		if (p.val != q.val) {
			return false;
		}

		if ( (p.left == null && q.left != null) || (p.left != null && q.left == null) ) {
			return false;
		} else if  ( (p.right == null && q.right != null) || (p.right != null && q.right == null) ) {
			return false;
		}
		boolean left = true;
		if (p.left != null && q.left != null) {
			left = recursion(p.left, q.left);
		}
		boolean right = true;
		if (p.right != null && q.right != null) {
			right = recursion(p.right, q.right);
		}

		return left && right;
	}
}