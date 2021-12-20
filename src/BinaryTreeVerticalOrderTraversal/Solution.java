package BinaryTreeVerticalOrderTraversal;
import java.util.*;

class Pair {
	TreeNode node;
	int col;

	Pair(TreeNode node, int col) {
		this.node = node;
		this.col = col;
	}
}

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
	public List<List<Integer>> verticalOrder(TreeNode root) {
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, List<Integer>> colMap = new HashMap<>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair curr = q.poll();

			if (curr.node != null) {
				if (!colMap.containsKey(curr.col)) {
					colMap.put(curr.col, new ArrayList<>());
				}
				colMap.get(curr.col).add(curr.node.val);

				q.add(new Pair(curr.node.left, curr.col - 1));
				q.add(new Pair(curr.node.right, curr.col + 1));
			}
		}

		List<Integer> colSorted = new ArrayList<>(colMap.keySet());
		Collections.sort(colSorted);

		List<List<Integer>> res = new ArrayList<>();

		for (int col : colSorted) {
			res.add(colMap.get(col));
		}

		return res;
	}
}




















