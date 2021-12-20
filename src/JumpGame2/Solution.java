package JumpGame2;
import java.util.*;

class Solution {
	public int jump(int[] nums) {
		int jumps = 0, currentJumpEnd = 0, farthest = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);

			if (i == currentJumpEnd) {
				jumps++;
				currentJumpEnd = farthest;
			}
		}

		return jumps;
	}


	// dynamic programming.

//	public int jump(int[] nums) {
//		int[] dp = new int[nums.length];
//		Arrays.fill(dp, Integer.MAX_VALUE);
//		int ans = recursion(dp, 0, 0, nums);
//		return ans;
//	}
//
//	int recursion(int[] dp,  int location, int jump, int[] nums) {
//		if (location == nums.length - 1) {
//			dp[location] = 0;
//			return 0;
//		}
//
//		if (dp[location] != Integer.MAX_VALUE) {
//			return dp[location];
//		}
//		int jumps = Integer.MAX_VALUE;
//		for (int i = location + 1; (i < nums.length) &&  (i <= (location + nums[location])) ; i++) {
//			int res = recursion(dp, i, jump , nums);
//
//			res = (res == Integer.MAX_VALUE ? Integer.MAX_VALUE : res + 1 );
//
//
//
//			jumps = Math.min(jumps, res);
//		}
//		dp[location] = jumps;
//		return jumps;
//	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.jump(new int[] {2,3,0,1,4});
	}
}