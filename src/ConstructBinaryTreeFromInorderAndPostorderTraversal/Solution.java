package ConstructBinaryTreeFromInorderAndPostorderTraversal;
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
	int[] inorder;
	int[] postorder;
	int postIdx;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		this.postIdx = postorder.length - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		TreeNode ans = recursion(0, inorder.length - 1, map);
		return ans;
	}

	TreeNode recursion(int iL, int iR, Map<Integer, Integer> map) {
		if (iR < iL ) {
			return null;
		}

		int nodeVal = postorder[postIdx];
		int targetIdx = map.get(nodeVal);
		postIdx--;

		TreeNode res = new TreeNode(nodeVal);

		res.right = recursion(targetIdx + 1, iR, map);

		res.left = recursion(iL, targetIdx - 1, map);

		return res;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
	}
}