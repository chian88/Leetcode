package DuplicateZeros;
import java.util.*;

class Solution {
	public void duplicateZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				shiftRight(arr, i);
				i++;
			}
		}
	}

	public void shiftRight(int[] arr, int k) {
		for (int i = arr.length - 1; i > k; i--) {
			arr[i] = arr[i - 1];
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.duplicateZeros(new int[] {1,0,2,3,0,4,5,0});
	}
}
