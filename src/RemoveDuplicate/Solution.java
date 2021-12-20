package RemoveDuplicate;
import java.util.*;


class Solution {
	public static int removeDuplicates(int[] nums) {
		int mainPtr = 0;
		int checkPtr = 0;
		int newLen = 1;
		while (checkPtr < nums.length) {
			if (nums[mainPtr] == nums[checkPtr]) {
				checkPtr++;
			} else {
				newLen++;
				nums[mainPtr + 1] = nums[checkPtr];
				mainPtr++;
			}
		}
		return newLen;
	}



	public static void main(String[] args) {
		removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
	}
}