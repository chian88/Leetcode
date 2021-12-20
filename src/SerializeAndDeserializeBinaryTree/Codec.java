package SerializeAndDeserializeBinaryTree;

import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
	int idx;
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		recursion(root, sb);
		return sb.toString();
	}

	void recursion(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("#,");
			return;
		}

		sb.append(node.val);
		sb.append(",");

		recursion(node.left, sb);
		recursion(node.right, sb);

	}

	// Decodes your encoded data to tree.

	public TreeNode deserialize(String data) {
		String[] serials = data.split(",");
		idx = 0;

		return buildTree(serials);
	}

	TreeNode buildTree(String[] serials) {
		if (serials[idx].equals("#")) {
			idx++;
			return null;
		}

		TreeNode res = new TreeNode(Integer.parseInt(serials[idx]));
		idx++;

		res.left = buildTree(serials);
		res.right = buildTree(serials);
		return res;
	}
}

//public class Codec {
//
//	// Encodes a tree to a single string.
//	public String serialize(TreeNode root) {
//		if (root == null) {
//			return "";
//		}
//		StringBuilder res = new StringBuilder();
//		preOrderTraversal(root ,res);
//		return res.toString();
//	}
//
//	void preOrderTraversal(TreeNode node, StringBuilder res) {
//		if (node == null) {
//			res.append("n,");
//			return;
//		}
//
//
//		res.append(node.val);
//		res.append(",");
//
//		preOrderTraversal(node.left, res);
//		preOrderTraversal(node.right, res);
//	}
//
//	// Decodes your encoded data to tree.
//	public TreeNode deserialize(String data) {
//		if (data.length() == 0) {
//			return null;
//		}
//
//		String[] datas = data.split(",");
//
//		TreeNode res = new TreeNode(Integer.parseInt(datas[0]));
//		recurse(datas, 1, res);
//
//		return res;
//	}
//
//	int recurse(String[] datas, int idx, TreeNode res) {
//		if (idx >= datas.length) {
//			return idx;
//		}
//
//		if (datas[idx].equals("n")) {
//			res.left = null;
//			idx ++;
//		} else {
//			res.left = new TreeNode(Integer.parseInt(datas[idx]));
//			idx = recurse(datas, idx + 1, res.left);
//		}
//
//		if (datas[idx].equals("n")) {
//			res.right = null;
//			idx ++;
//		} else {
//			res.right = new TreeNode(Integer.parseInt(datas[idx]));
//			idx = recurse(datas, idx + 1, res.right);
//		}
//		return idx;
//
//	}
//
//	public static void main(String[] args) {
//		Codec test = new Codec();
//		test.deserialize("1,2,3,n,n,4,n,n,5,n,n");
//	}
//}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));