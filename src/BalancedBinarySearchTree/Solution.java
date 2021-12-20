package BalancedBinarySearchTree;
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
	public TreeNode balanceBST(TreeNode root) {
		List<Integer> sortedInt = new ArrayList<>();

		inOrderTraversal(root, sortedInt);

		TreeNode ans = buildBalanceTrees(sortedInt, 0 , sortedInt.size());

		return ans;
	}

	TreeNode buildBalanceTrees(List<Integer> sortedInt, int lo, int hi) {
		if (hi <= lo) {
			return null;
		}
		int mid = lo + (hi - lo) / 2;
		TreeNode newNode = new TreeNode(sortedInt.get(mid),
				buildBalanceTrees(sortedInt, lo, mid),
				buildBalanceTrees(sortedInt, mid + 1, hi));

		return newNode;
	}


	void inOrderTraversal(TreeNode root, List<Integer> sortedInt) {
		if (root.left != null) {
			inOrderTraversal(root.left, sortedInt);
		}

		sortedInt.add(root.val);

		if (root.right != null) {
			inOrderTraversal(root.right, sortedInt);
		}
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		one.right = two;
		two.right = three;
		three.right = four;
		four.right = five;
		five.right = six;
		six.right = seven;

		Solution test = new Solution();
		test.balanceBST(one);

	}
}