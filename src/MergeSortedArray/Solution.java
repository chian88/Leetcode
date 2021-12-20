package MergeSortedArray;
import java.util.*;


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		int ptr1 = 0;
		int ptr2 = 0;
		while (ptr1 < m && ptr2 < n) {
			if (nums1[ptr1] <= nums2[ptr2]) {
				ptr1++;
			} else {
				move(nums1, ptr1);
				nums1[ptr1] = nums2[ptr2];
				ptr2++;
				ptr1++;
				m ++;

			}
		}


		while (ptr2 < n) {
			nums1[ptr1] = nums2[ptr2];
			ptr1++;
			ptr2++;
		}
    }

    private void move(int[] nums1, int k) {
    	for (int i = nums1.length - 1; i > k ; i--) {
    		nums1[i] = nums1[i - 1];
		}


	}

    public static void  main(String[] args) {
		Solution test = new Solution();
		test.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);


    }
}