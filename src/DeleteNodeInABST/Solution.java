package DeleteNodeInABST;
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
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode parent = null;

		if (root == null) {
			return null;
		} else if (root.val == key) {
			parent = root;

			if (parent.right != null) {
				TreeNode temp = parent.left;
				parent = parent.right;
				TreeNode attach = parent;

				while (attach.left != null) {
					attach = attach.left;
				}

				attach.left = temp;
			} else {
				parent = parent.left;
			}
			return parent;
		}



		parent = findParent(root, key);

		if (parent == null) {
			return root;
		} else if (parent.left.val == key) {
			if (parent.left.right != null) {
				TreeNode temp = parent.left.left;
				parent.left = parent.left.right;
				TreeNode attach = parent.left;
				while (attach.left != null) {
					attach = attach.left;
				}
				attach.left = temp;
			} else {
				parent.left = parent.left.left;
			}
		} else if (parent.right.val == key) {
			if (parent.right.left != null) {
				TreeNode temp = parent.right.right;
				parent.right = parent.right.left;

				TreeNode attach = parent.right;

				while (attach.right != null) {
					attach = attach.right;
				}

				attach.right = temp;
			} else {
				parent.right = parent.right.right;
			}
		}

		return root;
	}

	TreeNode findParent(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.left != null && root.left.val == key) {
			return root;
		} else if (root.right != null && root.right.val == key) {
			return root;
		}
		TreeNode left = null;
		if (root.left != null) {
			left = findParent(root.left, key);
		}

		if (left != null) {
			return left;
		}

		TreeNode right = null;
		if (root.right != null) {
			right = findParent(root.right, key);
		}

		if (right != null) {
			return right;
		}


		return null;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		TreeNode zero = new TreeNode(0);
		test.deleteNode(zero, 0);
	}
}