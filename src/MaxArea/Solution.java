package MaxArea;

import java.util.*;

class Solution {
    public static int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int maxArea = 0;

        while (leftPtr < rightPtr) {
            int width = (rightPtr - leftPtr);
            int high = Math.min(height[leftPtr], height[rightPtr]);
            int area = width * high;

            if (area > maxArea) {
                maxArea = area;
            }

            if (height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}