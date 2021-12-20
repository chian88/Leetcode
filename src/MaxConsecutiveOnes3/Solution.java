package MaxConsecutiveOnes3;
import java.util.*;

class Solution {
	public int longestOnes(int[] nums, int k) {
		int start = 0;
		int end = 0;
		int max = Integer.MIN_VALUE;
		int countOfZeros = 0;
		while (end < nums.length) {
			if (nums[end] == 1) {
				max = Math.max(max, end - start + 1);
				end++;
			} else if (countOfZeros < k) {
				countOfZeros++;
				max = Math.max(max, end - start + 1);
				end++;
			} else {
				if (nums[start] == 0) {
					countOfZeros--;
				}

				start++;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Solution teest = new Solution();
		teest.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
	}
}