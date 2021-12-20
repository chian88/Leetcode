package SortArrayByParity;
import java.util.*;

class Solution {
	public int[] sortArrayByParity(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (nums[left] % 2 == 0) {
				left++;
			} else if (nums[right] % 2 == 1) {
				right--;
			} else {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}

		return nums;
	}
}


//class Solution {
//	public int[] sortArrayByParity(int[] nums) {
//		int start = 0;
//		int end = nums.length - 1;
//
//		while (start < end) {
//			if (nums[start] % 2 == 0 && nums[end] % 2 == 1) {
//				start ++;
//				end --;
//			} else if (nums[start] % 2 == 0 && nums[end] % 2 == 0) {
//				start++;
//			} else if (nums[start] % 2 == 1 && nums[end] % 2 == 1) {
//				end--;
//			} else {
//				int temp = nums[start];
//				nums[start] = nums[end];
//				nums[end] = temp;
//				start++;
//				end--;
//			}
//		}
//
//		return nums;
//	}
//}