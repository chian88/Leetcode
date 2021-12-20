package GrumpyStoreOwner;
import java.util.*;

class Solution {
	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int res = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				res += customers[i];
			}
		}
		int left = 0;
		int right = minutes - 1;

		for (int i = left ; i <= right; i++) {
			if (grumpy[i] == 1) {
				res += customers[i];
			}
		}

		while (right < customers.length) {
			ans = Math.max(ans, res);
			right++;


			if (right < grumpy.length && grumpy[right] == 1) {
				res += customers[right];
			}

			if (grumpy[left] == 1) {
				res -= customers[left];
			}

			left++;
		}


		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxSatisfied(new int[] {1,0,1,2,1,1,7,5 }, new int[]{0,1,0,1,0,1,0,1}, 3);
	}
}