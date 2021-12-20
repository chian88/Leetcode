package ConstructBinarySearchTreeFromPreorderTraversal;
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
	int i;
	public TreeNode bstFromPreorder(int[] preorder) {
		i = 0;
		TreeNode res = recursion(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

		return res;
	}

	TreeNode recursion(int[] preorder, int min, int max) {
		if (i >= preorder.length) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[i]);
		i++;
		if (i < preorder.length && preorder[i] < node.val && preorder[i] > min) {
			node.left = recursion(preorder, min, node.val);
		}

		if (i < preorder.length && preorder[i] > node.val && preorder[i] < max) {
			node.right = recursion(preorder, node.val, max);
		}

		return node;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.bstFromPreorder(new int[]{8,5,1,7,10,12});
	}
}