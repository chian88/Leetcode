package LongestConsecutiveSequence;
import java.util.*;

class Solution {
	public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();

		for (int num : nums) {
			numSet.add(num);
		}
		int longestStreak = Integer.MIN_VALUE;
		for (int num : nums) {
			if (!numSet.contains(num - 1)) {
				int currentStreak = 1;

				while (numSet.contains(num + 1)) {
					currentStreak += 1;
					num = num + 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak == Integer.MIN_VALUE ? 0 : longestStreak;
	}


}