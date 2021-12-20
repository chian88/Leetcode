package LengthOfLongestFibonacciSubsequence;
import java.util.*;

class Solution {
	public int lenLongestFibSubseq(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int x : arr) {
			set.add(x);
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int num1 = arr[i];
				int num2 = arr[i] + arr[j];

				int len = 2;

				while (set.contains(num2)) {
					int temp = num2;
					num2 = num1 + num2;
					num1 = temp;
					ans = Math.max(ans, ++len);
				}
			}
		}

		return ans >= 3 ? ans : 0;
	}
}