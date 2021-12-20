package SortColors;
import java.util.*;

class Solution {
	public void sortColors(int[] nums) {
		if (nums.length <= 1) {
			return ;
		}


		int start = 0;


		while (start < nums.length && nums[start] == 0) {
			start ++;
		}

		int end = start + 1;

		while (end < nums.length) {
			if (nums[end] == 0) {
				// swap
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start++;
			}
			end ++;
		}


		start = nums.length - 1;
		while (start >= 0 && nums[start] == 2) {
			start--;
		}

		end = start - 1;

		while (end >= 0) {
			if (nums[end] == 2) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start--;
			}

			end--;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sortColors(new int[]{2,0,2,1,1,0});
	}
}