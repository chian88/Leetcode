package RotateArray;
import java.util.*;

class Solution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;


		int[] res = new int[nums.length];
		int write = 0;
		for (int i = nums.length - k; i < nums.length; i++) {
			res[write] = nums[i];
			write++;
		}

		for (int i = 0; i < (nums.length - k) ; i++) {
			res[write] = nums[i];
			write++;
		}

		for (int i = 0; i < res.length; i++) {
			nums[i] = res[i];
		}
 	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.rotate(new int[]{1,2,3,4,5,6,7}, 3);
	}
}