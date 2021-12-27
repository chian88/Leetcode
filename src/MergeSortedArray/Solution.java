package MergeSortedArray;
import java.util.*;


class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int lastPtr = m + n - 1;
		m--;
		n--;

		while (m >= 0 && n >= 0) {
			if (nums1[m] <= nums2[n]) {
				nums1[lastPtr--] = nums2[n];
				n--;
			} else {
				nums1[lastPtr--] = nums1[m];
				m--;
			}
		}

		while (m >= 0) {
			nums1[lastPtr--] = nums1[m];
			m--;
		}

		while (n >= 0) {
			nums1[lastPtr--] = nums2[n];
			n--;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.merge(new int[]{0}, 0, new int[]{1}, 1);
	}
}