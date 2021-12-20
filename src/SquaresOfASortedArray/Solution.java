package SquaresOfASortedArray;
import java.util.*;


class Solution {
	public int[] sortedSquares(int[] nums) {
		Deque<Integer> negativeNums = new ArrayDeque<>();

		for (int i = 0 ; i < nums.length; i++) {
			if (nums[i] < 0) {
				negativeNums.addFirst(nums[i]);
			} else {
				break;
			}
		}

		int[] res = new int[nums.length];

		int writePtr = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) continue;

			if (!negativeNums.isEmpty() &&
					Math.abs(nums[i]) > Math.abs(negativeNums.peekFirst())) {
				res[writePtr] = (int) Math.pow(negativeNums.pollFirst(), 2);
				i--;
			} else {
				res[writePtr] = (int) Math.pow(nums[i], 2);
			}

			writePtr ++ ;
		}

		while (!negativeNums.isEmpty()) {
			res[writePtr] = (int) Math.pow(negativeNums.pollFirst(), 2);
			writePtr++;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sortedSquares(new int[]{-4,-1,0,3,10});
	}
}