package NextGreaterElement3;
import java.util.*;

class Solution {
	public int nextGreaterElement(int n) {
		char[] nums = ("" + n).toCharArray();

		int targetIdx = findTargetIdx(nums);

		if (targetIdx == -1) {
			return targetIdx;
		}

		int swapIdx = findJustLargerthanTarget(nums, targetIdx);

		if (swapIdx == -1) {
			return swapIdx;
		}

		char temp = nums[targetIdx];
		nums[targetIdx] = nums[swapIdx];
		nums[swapIdx] = temp;

		reverseElements(nums, targetIdx);
		try {
			return Integer.parseInt(new String(nums));
		} catch(Exception e) {
			return -1;
		}
	}

	void reverseElements(char[] nums, int targetIdx) {
		int dist = nums.length - targetIdx - 1;
		int back = nums.length - 1;
		for (int i = 0; i < dist/2; i++) {
			char temp = nums[targetIdx + i + 1];
			nums[targetIdx + i + 1] = nums[back];
			nums[back] = temp;
			back--;

		}

	}

	int findJustLargerthanTarget(char[] nums, int targetIdx) {
		int resIdx = -1;
		for (int i = targetIdx + 1; i < nums.length; i++) {
			if (nums[i] - '0' > nums[targetIdx] - '0') {
				resIdx = i;

			}
		}

		return resIdx;
	}

	int findTargetIdx(char[] nums) {

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] - '0' < nums[i + 1] - '0') {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.nextGreaterElement(158476531);
	}
}