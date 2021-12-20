package MajorityElement;
import java.util.*;

public class Solution {

	private static int countInRange(int[] nums, int num, int lo, int hi) {
		int count = 0;
		for (int i = lo; i <= hi; i++) {
			if (nums[i] == num) {
				count++;
			}
		}

		return count;
	}
	// divide and conquer
	private static int majorityElementRec(int[] nums, int lo, int hi) {
		if (lo == hi) {
			return nums[lo];
		}

		int mid = (hi - lo) / 2 + lo;
		int left = majorityElementRec(nums, lo, mid);
		int right = majorityElementRec(nums, mid+1, hi);

		if (left == right) {
			return left;
		}

		int leftCount = countInRange(nums, left, lo, hi);
		int rightCount = countInRange(nums, right, lo, hi);

		return leftCount > rightCount ? left : right;
	}


	public static int majorityElement(int[] nums) {
		return majorityElementRec(nums, 0, nums.length - 1);
	}




	// randomization


//	private static int randRange(Random rand, int min, int max) {
//		return rand.nextInt(max - min)  + min;
//	}
//
//	private static int countOccurences(int[] nums, int num) {
//		int count = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == num) {
//				count++;
//			}
//		}
//
//		return count;
//	}
//
//    public static int majorityElement(int[] nums) {
//		Random rand = new Random();
//		int majorityCount = nums.length / 2;
//
//		while (true) {
//			int candidate = nums[randRange(rand, 0, nums.length)];
//			if (countOccurences(nums, candidate) > majorityCount) {
//				return candidate;
//			}
//		}
//
//	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
}
