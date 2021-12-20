package BalancedBinaryTree;
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
  class Struct {
	boolean balanced;
	int maxHeight;

	Struct(boolean balanced, int maxHeight) {
		this.balanced = balanced;
		this.maxHeight = maxHeight;
	}
  }
class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return recursion(root).balanced;
	}

	Struct recursion(TreeNode node) {
		if (node == null) {
			return new Struct (true, 0);
		}

		if (node.left == null && node.right == null) {
			return new Struct(true, 1);
		}

		Struct newRes = new Struct(true, Integer.MIN_VALUE);

		Struct left = recursion(node.left);
		newRes.balanced = newRes.balanced && left.balanced;
		newRes.maxHeight = Math.max(newRes.maxHeight, left.maxHeight);

		Struct right = recursion(node.right);
		newRes.balanced = newRes.balanced && right.balanced;
		newRes.maxHeight = Math.max(newRes.maxHeight, right.maxHeight);


		newRes.balanced = newRes.balanced && (Math.abs(left.maxHeight - right.maxHeight) <= 1);
		newRes.maxHeight = newRes.maxHeight + 1;
		return newRes;

	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode three1 = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode four1= new TreeNode(4);
		one.left = two;
		one.right = two2;
		two.left = three;
		two.right = three1;
		three.left = four;
		three.right = four1;
		Solution test = new Solution();
		test.isBalanced(one);
	}
}
















