package LongestArithmeticSubsequence;
import java.util.*;


class Solution {
	public int longestArithSeqLength(int[] nums) {

		Map<Integer, Integer>[] dp = new HashMap[nums.length];
		dp[0] = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			Map<Integer, Integer> counterI = new HashMap<>();
			for (int j = 0; j < i; j++) {
				int seq = nums[i] - nums[j];

				Map<Integer, Integer> counterJ = dp[j];
				if (counterJ.containsKey(seq)) {
					counterI.put(seq, counterJ.get(seq) + 1);
					max = Math.max(max, counterJ.get(seq) + 1);
				} else {
					counterI.put(seq, 1);
					max = Math.max(max, 1);
				}
			}
			dp[i] = counterI;
		}

		if (max == Integer.MIN_VALUE) {
			return 0;
		}

		return max + 1;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestArithSeqLength(new int[]{9,4,7,2,10});
	}
}