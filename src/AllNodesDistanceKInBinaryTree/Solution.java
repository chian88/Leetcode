package AllNodesDistanceKInBinaryTree;
import java.util.*;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		if (root == null) return new ArrayList<Integer>();

		List<Integer> res = new ArrayList<>();

		findNodeKDistanceRecur(root, target, k, res);

		return res;


	}

	public static void findNodeKDistanceRecur(TreeNode root, TreeNode target, int k, List<Integer> res) {
		if (root == null) return;

		int leftSubTreeDepth = findTargetDepth(root.left, target, 1);
		int rightSubTreeDepth = findTargetDepth(root.right, target, 1);

		if (leftSubTreeDepth >= 0) {
			// target is in left subtree
			int remainingDepth = k - leftSubTreeDepth;

			if (remainingDepth == 0) {
				res.add(root.val);
			} else if (remainingDepth > 0) {
				addResult(root.right, res, remainingDepth - 1);
			}

			findNodeKDistanceRecur(root.left, target, k, res);

		} else if (rightSubTreeDepth >= 0) {
			// target is in right subtree
			int remainingDepth = k - rightSubTreeDepth;

			if (remainingDepth == 0) {
				res.add(root.val);
			} else if (remainingDepth > 0) {
				addResult(root.left, res, remainingDepth - 1);
			}

			findNodeKDistanceRecur(root.right, target, k, res);
		} else if (root.val == target.val) {
			// target is here.

			addResult(root, res, k);
			findNodeKDistanceRecur(root.left, target, k, res);
			findNodeKDistanceRecur(root.right, target, k, res);
		}
	}

	private static void addResult (TreeNode root, List<Integer> res, int remainingDepth) {
		if (root == null) return;
		if (remainingDepth == 0) {
			res.add(root.val);
			return;
		} else {
			addResult(root.left, res, remainingDepth - 1);
			addResult(root.right, res, remainingDepth - 1);
		}
	}

	private static int findTargetDepth (TreeNode root, TreeNode target, int depth) {
		if (root == null) return -1;
		if (root.val == target.val) return depth;

		depth += 1;

		int leftSubTreeDepth = findTargetDepth(root.left, target, depth);

		if (leftSubTreeDepth >= 0) return leftSubTreeDepth;

		int rightSubTreeDepth = findTargetDepth(root.right, target, depth);

		if (rightSubTreeDepth >= 0) return rightSubTreeDepth;

		return -1;
	}

	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);

		three.left = five;
		three.right = one;
		five.left = six;
		five.right = two;
		two.left = seven;
		two.right = four;
		one.left = zero;
		one.right = eight;
		distanceK(three, five, 2);
	}

}