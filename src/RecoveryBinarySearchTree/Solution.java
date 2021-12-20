package RecoveryBinarySearchTree;

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
	public void recoverTree(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		recursion(root, inorder);
		int[] swapNum = swapTwoNum(inorder);
		Collections.swap(inorder, swapNum[0] , swapNum[1]);
		reconstructBinaryTree(root, inorder, 0);
	}

	int[] swapTwoNum(List<Integer> inorder) {
		Integer x = null;
		Integer y = null;


		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i) > inorder.get(i + 1)) {
				y = i + 1;

				if (x == null) {
					x = i;
				} else {
					break;
				}
			}
		}

		return new int[]{x, y};
	}

	int reconstructBinaryTree(TreeNode root, List<Integer> inorder, int ptr) {


		if (root.left != null) {
			ptr = reconstructBinaryTree(root.left, inorder, ptr);
		}
		root.val = inorder.get(ptr++);
		if (root.right != null) {
			ptr = reconstructBinaryTree(root.right, inorder, ptr);
		}

		return ptr;
	}

	void recursion(TreeNode root, List<Integer> inorder) {
		if (root.left != null) {
			recursion(root.left, inorder);
		}

		inorder.add(root.val);

		if (root.right != null) {
			recursion(root.right, inorder);
		}


	}

	public static void main(String[] args) {
		TreeNode two = new TreeNode(1);
		TreeNode one = new TreeNode(3);
		TreeNode three = new TreeNode(2);
		two.left = one;
		one.right = three;
		Solution test = new Solution();
		test.recoverTree(two);
	}
}