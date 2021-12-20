package BinaryTreeZigZagLevelOrderTraversal;
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		boolean leftToRight = true;
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.add(root);

		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> intermediateRes = new ArrayList<>();
			Deque<TreeNode> tempDeque = new ArrayDeque<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = deque.pollFirst();
				intermediateRes.add(curr.val);
				if (leftToRight) {

					if (curr.left != null) tempDeque.addFirst(curr.left);
					if (curr.right != null) tempDeque.addFirst(curr.right);
				} else {

					if (curr.right != null) tempDeque.addFirst(curr.right);
					if (curr.left != null) tempDeque.addFirst(curr.left);
				}


			}
			res.add(intermediateRes);
			leftToRight = !leftToRight;
			deque.addAll(tempDeque);
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		one.left = two;
		one.right = three;
		three.right = four;
		three.left = five;
		two.right = six;
		two.left = seven;
		Solution test = new Solution();
		test.zigzagLevelOrder(one);
	}

}