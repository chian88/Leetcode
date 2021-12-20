package SerializeAndDeserializeBST;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		dfs(root, str);

		return str.toString();
	}

	void dfs(TreeNode node, StringBuilder str) {
		if (node == null) {
			return;
		}

		str.append(node.val);
		str.append(",");

		if (node.left != null) {
			dfs(node.left, str);
		}

		if (node.right != null) {
			dfs(node.right, str);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0) {
			return null;
		}
		String[] dataArr = data.split(",");

		TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));

		buildTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE, dataArr, 1);

		return root;
	}

	int buildTree(TreeNode node, int max, int min, String[] data, int idx) {
		if (idx >= data.length) {
			return idx;
		}
		int newVal = Integer.parseInt(data[idx]);
		if (newVal <= node.val && newVal >= min ) {
			node.left = new TreeNode(newVal);
			idx = buildTree(node.left, node.val, min, data, idx + 1);
		}
		if (idx >= data.length) {
			return idx;
		}
		newVal = Integer.parseInt(data[idx]);

		if (newVal > node.val && newVal <= max) {
			node.right = new TreeNode(newVal);
			idx = buildTree(node.right, max, node.val, data, idx + 1);
		}

		return idx;
	}

	public static void main(String[] args) {
		Codec test = new Codec();

		String serial = test.serialize(null);
		test.deserialize(serial);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;