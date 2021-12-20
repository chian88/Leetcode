package MaximumWidthOfBinaryTree;
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

class Pair {
	   int index;
	   TreeNode node;

	   Pair(int index, TreeNode node) {
		   this.index = index;
		   this.node = node;
	   }
}

class Solution {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		int maxWidth = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			Pair head = q.peek();
			Pair last = null;
			while (size > 0) {
				Pair curr = q.poll();
				last = curr;
				TreeNode currNode = curr.node;


				if (currNode.left != null) {
					q.add(new Pair(curr.index * 2, currNode.left));
				}

				if (currNode.right != null) {
					q.add(new Pair(curr.index * 2 + 1, currNode.right));
				}

				size--;
			}

			maxWidth = Math.max(maxWidth, last.index - head.index + 1);
		}
		return maxWidth;
	}


	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode five = new TreeNode(5);

		TreeNode nine = new TreeNode(9);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		one.left = three;
		one.right = two;
		three.left = five;

		two.right = nine;
		five.left = six;
		nine.right = seven;



		Solution test = new Solution();
		test.widthOfBinaryTree(one);
	}
}