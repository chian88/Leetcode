package ConstructBinaryTreefromPreorderandInorderTraversal;

//class Structure {
//	TreeNode node;
//	int latestIdx;
//
//	Structure(TreeNode node, int latestIdx) {
//		this.node = node;
//		this.latestIdx = latestIdx;
//	}
//}

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
	int preorderIdx;
	int[] preorder;
	int[] inorder;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIdx = 0;
		this.preorder = preorder;
		this.inorder = inorder;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return recursion(0, inorder.length - 1, map);
	}

	TreeNode recursion(int iL, int iR, Map<Integer, Integer> map) {
		if (iR < iL) {
			return null;
		}


		int nodeVal = preorder[preorderIdx];
		preorderIdx++;

		TreeNode res = new TreeNode(nodeVal);

		int targetIdx = map.get(nodeVal);

		res.left = recursion(iL, targetIdx - 1, map);

		res.right = recursion(targetIdx + 1, iR, map);

		return res;
	}
}


//class Solution {
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		Structure ans = recursion(preorder, inorder, 0, 0, inorder.length);
//		return ans.node;
//	}
//
//	Structure recursion(int[] preorder, int[] inorder, int preorderIdx, int left, int right) {
//		if (right <= left || preorderIdx >= preorder.length) {
//			return new Structure(null, preorderIdx - 1);
//		}
//		int rootVal = preorder[preorderIdx];
//		int targetIdx = -1;
//		for (int i = left; i < right; i++) {
//			if (inorder[i] == rootVal) {
//				targetIdx = i;
//			}
//		}
//
//		TreeNode res = new TreeNode(rootVal);
//		Structure leftSub = recursion(preorder, inorder, preorderIdx + 1, left, targetIdx);
//		Structure rightSub = recursion(preorder, inorder, leftSub.latestIdx + 1, targetIdx + 1, right);
//		res.left = leftSub.node;
//		res.right = rightSub.node;
//		return new Structure(res, rightSub.latestIdx);
//
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.buildTree(new int[] {1,2,4,8,9,10,11,5,3,6,7}, new int[]{8,4,10,9,11,2,5,1,6,3,7});
//	}
//}