package ConstructFromPrePost;
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

 class Structure {
	TreeNode node;
	int idx;

	Structure(TreeNode node, int idx) {
		this.node = node;
		this.idx = idx;
	}
 }

class Solution {
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		Structure ans =  recursion(-1, 0, postorder.length - 1, preorder, postorder);
		return ans.node;
	}

	Structure recursion(int preorderIdx, int postOrderLeft, int postOrderRight, int[] preorder, int[] postorder) {


		preorderIdx += 1;
		if (preorderIdx >= preorder.length) {
			return new Structure(null, preorderIdx - 1);
		}
		int found = -1;
		for (int i = postOrderLeft; i <= postOrderRight; i++) {
			if (postorder[i] == preorder[preorderIdx]) {
				found = i;
				break;
			}
		}

		if (found != -1) {
			TreeNode node = new TreeNode(preorder[preorderIdx]);
			Structure leftStruct = recursion(preorderIdx, postOrderLeft, found - 1, preorder, postorder);
			node.left = leftStruct.node;
			Structure rightStruct = recursion(leftStruct.idx, postOrderLeft, found - 1, preorder, postorder);
			node.right = rightStruct.node;
			return new Structure(node, rightStruct.idx);
		} else {
			return new Structure(null, preorderIdx - 1);
		}



	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
	}
}