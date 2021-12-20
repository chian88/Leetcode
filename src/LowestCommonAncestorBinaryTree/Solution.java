package LowestCommonAncestorBinaryTree;
import java.util.*;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Structure {
	boolean foundP;
	boolean foundQ;
	TreeNode ancestor;
}


class Solution {
	TreeNode p;
	TreeNode q;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.p = p;
		this.q = q;
		Structure ans = recursion(root);
		return ans.ancestor;
	}

	Structure recursion(TreeNode node) {
		Structure res = new Structure();
		if (node == null) {
			return res;
		}

		if (node.val == p.val) {
			res.foundP = true;
		}

		if (node.val == q.val) {
			res.foundQ = true;
		}

		Structure leftStructure = recursion(node.left);
		if (leftStructure.ancestor != null) {
			return leftStructure;
		}
		res.foundP = res.foundP || leftStructure.foundP;
		res.foundQ = res.foundQ || leftStructure.foundQ;

		Structure rightStructure = recursion(node.right);
		if (rightStructure.ancestor != null) {
			return rightStructure;
		}
		res.foundP = res.foundP || rightStructure.foundP;
		res.foundQ = res.foundQ || rightStructure.foundQ;

		if (res.foundQ && res.foundP && res.ancestor == null) {
			res.ancestor = node;
		}

		return res;
	}


	public static void main(String[] args) {
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);
//		three.left = five;
//		five.left = six;
//		five.right = two;
//		two.left = seven;
//		two.right = four;
//		three.right = one;
//		one.left = zero;
//		one.right = eight;
		one.left = two;
		Solution test = new Solution();
		test.lowestCommonAncestor(one, one, two);
	}
}

//class Solution {
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		return lcaHelper(root, p, q).ancestor;
//	}
//
//	public AncestorState lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null) return new AncestorState(0, null);
//
//		AncestorState leftAncestorState = lcaHelper(root.left, p, q);
//
//		if (leftAncestorState.numOfNodes == 2) return leftAncestorState;
//
//		AncestorState rightAncestorState = lcaHelper(root.right, p, q);
//
//		if (rightAncestorState.numOfNodes == 2) return rightAncestorState;
//
//		int numOfNodesSofar = leftAncestorState.numOfNodes +
//				rightAncestorState.numOfNodes +
//				(root.val == p.val ? 1 : 0 ) +
//				(root.val == q.val ? 1 : 0) ;
//
//		return new AncestorState(numOfNodesSofar, (numOfNodesSofar == 2 ? root : null));
//
//	}
//}