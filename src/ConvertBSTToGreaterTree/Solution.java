package ConvertBSTToGreaterTree;

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
	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		recursion(root, 0);
		return root;
	}

	int recursion(TreeNode node, int rolling) {
		if(node.right != null) {
			rolling = recursion(node.right, rolling);
		}

		rolling = node.val + rolling;
		node.val = rolling;


		if (node.left != null) {
			rolling = recursion(node.left, rolling);
		}

		return rolling;
	}


}