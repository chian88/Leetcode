package EqualTreePartition;
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

	Stack<Integer> seen;
	public boolean checkEqualTree(TreeNode root) {
		seen = new Stack();

		int total = sum(root);
		seen.pop();

		if (total % 2 == 0) {
			for (int s : seen) {
				if (s == total / 2) return true;
			}
		}

		return false;
	}


	public int sum(TreeNode node) {
		if (node == null) return 0;
		seen.push(sum(node.left) + sum(node.right) + node.val);
		return seen.peek();
	}
}