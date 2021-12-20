package MedianOfTwoSortedArrays;

import java.util.Arrays;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean even = ((nums1.length + nums2.length) % 2) == 0;



        int[] shorter;
        int[] longer;

        if (nums1.length > nums2.length) {
            longer = nums1;
            shorter = nums2;
        } else {
            longer = nums2;
            shorter = nums1;
        }

        int start = 0;
        int end = shorter.length;

        while (true) {


            int partitionX = (start + end) / 2;
            int partitionY = ((shorter.length + longer.length + 1) / 2) - partitionX;

            int[] leftX = Arrays.copyOfRange(shorter, 0, partitionX);
            int[] rightX = Arrays.copyOfRange(shorter, partitionX, shorter.length);
            int[] leftY = Arrays.copyOfRange(longer, 0, partitionY);
            int[] rightY = Arrays.copyOfRange(longer, partitionY, longer.length);


            int maxLeftX = Integer.MIN_VALUE;
            if (leftX.length > 0) {
                maxLeftX = leftX[leftX.length - 1];
            }

            int maxLeftY = Integer.MIN_VALUE;
            if (leftY.length > 0) {
                maxLeftY = leftY[leftY.length - 1];
            }

            int minRightX = Integer.MAX_VALUE;
            if (rightX.length > 0) {
                minRightX = rightX[0];
            }

            int minRightY = Integer.MAX_VALUE;
            if (rightY.length > 0) {
                minRightY = rightY[0];
            }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // found

                if (even) {
                    double x1 = Math.max(maxLeftX, maxLeftY);
                    double x2 = Math.min(minRightX, minRightY);
                    return (x1 + x2) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // move toward left in X
                end = partitionX - 1;
            } else {
                // move toward right in x, meaning toward left in y

                start = partitionX + 1;
            }
        }



    }

    public static void main(String[] args) {
        double ans = findMedianSortedArrays(new int[]{23,26,31,35}, new int[]{3,5,7,9,11,16});
    }
}
