package RelativeSortArray;

import java.util.*;

class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] counter = new int[1001];
		Set<Integer> remaining = new TreeSet<>();
		for (int i = 0; i < arr1.length; i++) {
			counter[arr1[i]]++;
			remaining.add(arr1[i]);
		}

		int ptr = 0;

		for (int i = 0; i < arr2.length; i++) {
			int num = arr2[i];

			remaining.remove(num);

			while (counter[num] > 0) {

				arr1[ptr] = num;
				ptr++;
				counter[num]--;
			}
		}

		for (int num : remaining) {

			while (counter[num] > 0) {
				arr1[ptr] = num;
				ptr++;
				counter[num]--;
			}

		}

		return arr1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
	}
}