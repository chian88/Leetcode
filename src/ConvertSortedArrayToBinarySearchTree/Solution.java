package ConvertSortedArrayToBinarySearchTree;
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
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode ans = recursion(0, nums.length, nums);
		return ans;
	}

	TreeNode recursion(int left, int right, int[] nums) {
		if (right <= left) {
			return null;
		}

		int mid = left + (right - left) / 2;

		TreeNode node = new TreeNode(nums[mid], recursion(left, mid, nums), recursion(mid + 1, right, nums));

		return node;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
	}
}