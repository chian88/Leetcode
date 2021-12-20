package FlattenBinaryTreeToLinkedList;

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
	public void flatten(TreeNode root) {
		flattenHelper(root);
		int x = 1;
	}

	public void flattenHelper(TreeNode node) {
		if (node == null) return;
		if (node.left != null) {
			attachLeftChildMostRightArmToRightNode(node.left, node.right);
			node.right = node.left;
		}

		node.left = null;
		flattenHelper(node.right);
	}

	public void attachLeftChildMostRightArmToRightNode(TreeNode left, TreeNode right) {
		while(left.right != null) {
			left = left.right;
		}

		left.right = right;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		one.left = two;
		two.left = three;
		two.right = four;
		one.right = five;
		five.right = six;

		Solution test = new Solution();
		test.flatten(one);

	}
}