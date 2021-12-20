package SymmetricTree;

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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return recursion(root.left, root.right);
	}

	boolean recursion(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null && right != null) {
			return false;
		}

		if (right == null && left != null) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}
		return recursion(left.left, right.right) && recursion(left.right, right.left);
	}
}



//class Solution {
//	public boolean isSymmetric(TreeNode root) {
//		return recurse(root.left, root.right);
//	}
//
//	boolean recurse(TreeNode left, TreeNode right) {
//		if (left == null && right == null) {
//			return true;
//		}
//
//		if (left == null && right != null) {
//			return false;
//		}
//
//		if (right == null && left != null) {
//			return false;
//		}
//
//		if (left.val != right.val) {
//			return false;
//		}
//
//		boolean first = recurse(left.left, right.right);
//		boolean second = recurse(left.right, right.left);
//
//		return (first && second);
//
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//
//		TreeNode one = new TreeNode(1);
//		//test.isSymmetric()
//	}
//}