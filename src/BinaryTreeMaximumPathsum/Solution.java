package BinaryTreeMaximumPathsum;

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
	public int maxPathSum(TreeNode root) {
		int[] ans = recursion(root);

		return ans[1];
	}

	int[] recursion(TreeNode root) {
		if (root == null) {
			return new int[]{0, Integer.MIN_VALUE};
		}
		int[] left = recursion(root.left);

		int[] right = recursion(root.right);

		int mcsb = Math.max(left[0], right[0]);

		int msb = Math.max(mcsb + root.val, root.val);

		int mst = Math.max(msb, left[0] + root.val + right[0]);

		int rmps = Math.max(Math.max(left[1], right[1]), mst);

		return new int[]{msb, rmps};
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		TreeNode one = new TreeNode(1);
		root.left = one;
		Solution test = new Solution();
		test.maxPathSum(root);
	}
}