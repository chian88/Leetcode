package SumOfAllOddLengthSubarray;

class Solution {
	public int sumOddLengthSubarrays(int[] arr) {
		int[] sums = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				sums[i] = arr[i];
			} else {
				sums[i] = arr[i] + sums[i - 1];
			}
		}
		int res = 0;
		for (int i = 2; i < sums.length; i++) {
			if ((i - 0 + 1) % 2 == 1) {
				// odd length
				if (i - 3 > 0) {

				}
			} else {

			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sumOddLengthSubarrays(new int[]{1,4,2,5,3});
	}
}