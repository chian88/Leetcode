package BinaryTreePreorderTraversal;
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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			res.add(root.val);
			if (root.right != null) {
				stack.addFirst(root.right);
			}
			if (root.left != null) {
				stack.addFirst(root.left);
			}

			root = stack.pollFirst();
		}


		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		test.preorderTraversal(one);
	}
}