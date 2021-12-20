package FrogJump;

class Solution {
	public boolean canCross(int[] stones) {
		Boolean[][] dp = new Boolean[stones.length + 1][ stones.length + 1];

		boolean ans = recursion(stones, -1,0, 0, dp);
		return ans;
	}

	boolean recursion(int[] stones, int prevIdx,  int currIdx, int k, Boolean[][] dp) {
		if (currIdx == 0) {
			if (stones[1] != stones[0] + 1) {
				return false;
			}

			return recursion(stones, 0, 1, 1, dp);
		}


		if (currIdx == stones.length - 1) {
			return true;
		}

		if (dp[prevIdx][currIdx] != null) {
			return dp[prevIdx][currIdx] ;
		}


		for (int stoneIdx = currIdx + 1; stoneIdx < stones.length; stoneIdx++) {
			int diff = stones[stoneIdx] - stones[currIdx];
			if ( ( diff <= k + 1) &&  (diff >= k - 1) ) {
				if (recursion(stones, currIdx, stoneIdx, stones[stoneIdx] - stones[currIdx], dp) ){
					return true;
				}
			}
		}

		dp[prevIdx][currIdx] = false;

		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canCross(new int[]{0,1,2,3,4,8,9,11});
	}
}