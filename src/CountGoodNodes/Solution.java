package CountGoodNodes;

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
	public static int goodNodes(TreeNode root) {
		return goodNodesHelper(root, Integer.MIN_VALUE, 0);
	}

	static int goodNodesHelper(TreeNode node, int max, int count) {
		if (node == null) return 0;
		if (node.val >= max) {
			max = node.val;
		}
		count += goodNodesHelper(node.left, max, 0);
		count += goodNodesHelper(node.right, max, 0);

		if (node.val >= max) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1, three, null);
		TreeNode five = new TreeNode(5);
		TreeNode one2 = new TreeNode(1);
		TreeNode four = new TreeNode(4, one2, five);
		TreeNode three2 = new TreeNode(3, one, four);
		goodNodes(three2);


	}
}