package UniqueBinarySearchTree2;
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
	public List<TreeNode> generateTrees(int n) {
		return recursion(1, n);
	}

	List<TreeNode> recursion(int start, int end) {
		if (start > end) {
			List<TreeNode> res = new ArrayList<>();
			res.add(null);
			return res;
		}
		List<TreeNode> res = new ArrayList<>();
		for (int root = start; root <= end; root++) {

			List<TreeNode> left = recursion(start, root - 1);
			List<TreeNode> right = recursion(root + 1, end);



			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode curr = new TreeNode(root);
					curr.left = l;
					curr.right = r;
					res.add(curr);
				}
			}


		}

		return res;
	}
}






//class Solution {
//	public List<TreeNode> generateTrees(int n) {
//		return recursion(1, n);
//	}
//
//	List<TreeNode> recursion(int start, int end) {
//		List<TreeNode> allTrees = new ArrayList<>();
//		if (start > end) {
//			allTrees.add(null);
//		}
//
//		for (int root = start; root <= end; root++) {
//			List<TreeNode> left = recursion(start, root - 1);
//			List<TreeNode> right = recursion(root + 1, end);
//
//			for (TreeNode l : left) {
//				for (TreeNode r : right) {
//					TreeNode curr = new TreeNode(root);
//					curr.left = l;
//					curr.right = r;
//
//					allTrees.add(curr);
//				}
//			}
//		}
//		return allTrees;
//	}
//}