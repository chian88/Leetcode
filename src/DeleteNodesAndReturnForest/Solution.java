package DeleteNodesAndReturnForest;
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
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> toDelete = new HashSet<>();
		for (int i : to_delete) {
			toDelete.add(i);
		}

		List<TreeNode> res = new ArrayList<>();

		recursion(root, toDelete, true, res);

		return res;
	}

	void recursion(TreeNode root, Set<Integer> toDelete, boolean startNewRoot, List<TreeNode> res) {
		if (root == null) {
			return;
		}

		if (toDelete.contains(root.val)) {
			recursion(root.left, toDelete, true, res);
			recursion(root.right, toDelete, true, res);

			return;
		}


		if (startNewRoot ) {
			res.add(root);
		}


		if (root.left != null) {
			TreeNode temp = root.left;
			if (toDelete.contains(root.left.val)) {
				root.left = null;
			}

			recursion(temp, toDelete, false, res);
		}

		if (root.right != null) {
			TreeNode temp = root.right;

			if (toDelete.contains(root.right.val)) {
				root.right = null;
			}
			recursion(temp, toDelete, false, res);
		}



	}

	public static void main(String[] args) {
		Solution test = new Solution();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		one.left = two;
		one.right = three;
		two.left= four;
		two.right = five;
		three.left = six;
		three.right = seven;
		test.delNodes(one, new int[]{3,5});
	}
}