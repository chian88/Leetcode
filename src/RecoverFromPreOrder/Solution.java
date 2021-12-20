package RecoverFromPreOrder;
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

  class Pairs {
	TreeNode root;
	int lastStrIdx;

	Pairs(TreeNode root, int lastStrIdx) {
		this.root = root;
		this.lastStrIdx = lastStrIdx;
	}
  }

class Solution {
	public TreeNode recoverFromPreorder(String traversal) {
		if (traversal.length() == 0) return null;

		Pairs ans =  recurse(0, 0, traversal);
		return ans.root;
	}

	Pairs recurse(int strIdx, int depth, String traversal) {
		int numDash = 0;
		if (strIdx >= traversal.length()) {
			return new Pairs(null, strIdx -1 );
		}

		while (traversal.charAt(strIdx) == '-') {
			strIdx += 1;
			numDash += 1;
		}


		if (depth == numDash) {
			int endIdx = strIdx + 1;
			while (endIdx < traversal.length() &&
					Character.isDigit(traversal.charAt(endIdx))) {
				endIdx += 1;
			}
			TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(strIdx, endIdx)));
			strIdx = endIdx - 1;
			Pairs leftSubtree = recurse(strIdx + 1, depth + 1, traversal);
			strIdx = leftSubtree.lastStrIdx;
			root.left = leftSubtree.root;
			Pairs rightSubtree = recurse(strIdx + 1, depth + 1, traversal);
			root.right = rightSubtree.root;
			strIdx = rightSubtree.lastStrIdx;
			return new Pairs(root, strIdx);
		}

		return new Pairs(null, strIdx - numDash - 1);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.recoverFromPreorder("1-2--3--4-5--6--7");
	}
}