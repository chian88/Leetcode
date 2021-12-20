package JumpGame;
class Solution {
	public boolean canJump(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[nums.length - 1] = true;

		for (int i = nums.length - 2; i >= 0; i--) {
			int k = nums[i];

			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if (dp[j]) {
					dp[i] = true;
				}
			}
		}

		return dp[0];
	}

//	public boolean canJump(int[] nums) {
//		boolean[] dp = new boolean[nums.length];
//
//
//		return canJumpHelper(nums, 0, dp);
//	}
//
//	public boolean canJumpHelper(int[] nums, int currentIdx, boolean[] dp) {
//		if (currentIdx >= nums.length - 1) return true;
//
//		if (dp[currentIdx]) return false;
//
//		int steps = nums[currentIdx];
//
//		for (int i = 1; i <= steps ; i++) {
//			if (canJumpHelper(nums, currentIdx + i, dp)) {
//				return true;
//			}
//		}
//		dp[currentIdx] = true;
//		return false;
//	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canJump(new int[] {2,0});
	}
}