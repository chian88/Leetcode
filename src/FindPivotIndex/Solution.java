package FindPivotIndex;

class Solution {
	public int pivotIndex(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] + nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] + nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			if (left[i] == right[i]) {
				return i;
			}
		}

		return -1;
	}
}






















//public class Solution {
//
//	public int pivotIndex(int[] nums) {
//		int[] leftSum = new int[nums.length + 1];
//		int[] rightSum = new int[nums.length + 1];
//
//		leftSum[0] = 0;
//		rightSum[rightSum.length - 1] = 0;
//
//		for (int i = 0; i < nums.length; i++) {
//			leftSum[i + 1] = leftSum[i] + nums[i];
//		}
//
//		for (int i = nums.length - 1; i >= 0; i--) {
//			rightSum[i] = rightSum[i + 1] + nums[i];
//		}
//
//		for (int i = 0; i < leftSum.length - 1; i ++) {
//			if (leftSum[i] == rightSum[i + 1]) {
//				return i;
//			}
//		}
//
//		return -1;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.pivotIndex(new int[]{-1,-1,0,0, -1,-1});
//	}
//}
