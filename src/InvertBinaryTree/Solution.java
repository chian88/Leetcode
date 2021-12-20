package InvertBinaryTree;

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
	public TreeNode invertTree(TreeNode root) {
		TreeNode res = new TreeNode(root.val);
		recurse(root, res);
		return res;
	}

	void recurse(TreeNode root, TreeNode res) {
		if (root.left != null) {
			res.right = new TreeNode(root.left.val);
			recurse(root.left, res.right);
		}

		if (root.right != null) {
			res.left = new TreeNode(root.right.val);
			recurse(root.right, res.left);
		}
	}

	public static void main(String[] args) {
		TreeNode four = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode nine = new TreeNode(9);

		four.left = two;
		four.right = seven;
		two.left = one;
		two.right = three;
		seven.left = six;
		seven.right = nine;

		Solution test = new Solution();
		test.invertTree(four);
	}
}