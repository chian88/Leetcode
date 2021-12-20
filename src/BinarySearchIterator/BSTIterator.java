package BinarySearchIterator;
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

class BSTIterator {
	private List<Integer> inOrderTraversal = new ArrayList<>();
	private int ptr = 0;
	public BSTIterator(TreeNode root) {
		inOrderTraversal.add(-1);
		generateTraversal(inOrderTraversal, root);
	}

	public void generateTraversal(List<Integer> inOrderTraversal, TreeNode root) {
		if (root == null) return;
		generateTraversal(inOrderTraversal, root.left);
		inOrderTraversal.add(root.val);
		generateTraversal(inOrderTraversal, root.right);
	}

	public int next() {
		ptr += 1;

		return inOrderTraversal.get(ptr);
	}

	public boolean hasNext() {
		return (ptr + 1) < inOrderTraversal.size();
	}
}