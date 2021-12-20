package MaxChunsToMakeSorted;
import java.util.*;

class Solution {
	public int maxChunksToSorted(int[] arr) {


		int res = 0;
		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxSoFar = Math.max(arr[i], maxSoFar);

			if (maxSoFar <= i) {
				res++;
				maxSoFar = Integer.MIN_VALUE;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxChunksToSorted(new int[]{4,3,2,1,0});
	}
}