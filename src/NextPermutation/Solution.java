package NextPermutation;

import java.util.Arrays;

class Solution {
    public static void nextPermutation(int[] nums) {
        int targetIdx = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            int prev = nums[i - 1];
            int curr = nums[i];

            if (prev < curr) {
                targetIdx = i - 1;
                break;
            }
        }
        int minNum = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = targetIdx + 1; i < nums.length; i++) {
            if (nums[i] > nums[targetIdx] && nums[i] < minNum) {
                minIdx = i;
                minNum = nums[i];
            }
        }

        int temp = nums[targetIdx];
        nums[targetIdx] = minNum;
        nums[minIdx] = temp;

        int[] rightSublist = Arrays.copyOfRange(nums, targetIdx + 1, nums.length);
        Arrays.sort(rightSublist);

        int counter = 0;

        for (int i = targetIdx + 1; i < nums.length; i++) {
            nums[i] = rightSublist[counter];
            counter++;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,5,8,4,7,6,5,3,1});
    }
}