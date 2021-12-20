package BinaryTreeInorderTraversal;
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
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();

		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		stack.add(root);
		Set<TreeNode> visited = new HashSet<>();
		TreeNode curr = root;
		while (!stack.isEmpty()) {
			if (curr.left != null) {
				stack.add(curr.left);
				curr = curr.left;
				continue;
			}
			TreeNode node = stack.pop();
			res.add(node.val);

			if (node.right != null) {
				stack.add(node.right);
				curr = node.right;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);

		one.left = two;
		one.right = four;
		two.left = three;
		Solution test = new Solution();
		test.inorderTraversal(one);
	}
}

//class Solution {
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		Deque<TreeNode> stack = new ArrayDeque<>();
//		if (root == null) {
//			return res;
//		}
//		stack.addFirst(root);
//		while (!stack.isEmpty()) {
//
//			if (root.right != null) {
//				stack.addFirst(root.right);
//			}
//			if (root.left != null) {
//				stack.addFirst(root.left);
//			}
//
//			root = stack.pollFirst();
//			res.add(root.val);
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		TreeNode one = new TreeNode(1);
//		TreeNode two = new TreeNode(2);
//		TreeNode three = new TreeNode(3);
//		TreeNode four = new TreeNode(4);
//		TreeNode five = new TreeNode(5);
//		one.left = two;
//		one.right = three;
//		two.left = four;
//		two.right = five;
//		test.inorderTraversal(one);
//	}
//
//
//}

//class Solution {
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		if (root == null) {
//			return res;
//		}
//		recursion(root, res);
//		return res;
//	}
//
//	void recursion(TreeNode node, List<Integer> res) {
//		if (node.left != null) {
//			recursion(node.left, res);
//		}
//
//		res.add(node.val);
//
//		if (node.right != null) {
//			recursion(node.right, res);
//		}
//
//	}
//}