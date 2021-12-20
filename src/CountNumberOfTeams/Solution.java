package CountNumberOfTeams;
import java.util.*;
class Solution {
	public int numTeams(int[] rating) {
		int[] left = new int[rating.length];
		int[] right = new int[rating.length];


		for (int i = 1; i < rating.length; i++) {
			for (int j = 0; j < i; j ++) {
				if (rating[i] > rating[j]) {
					left[i] += 1;
				}
			}
		}

		for (int i = rating.length - 2; i >= 0; i--) {
			for (int j = rating.length - 1; j > i; j--) {
				if (rating[i] > rating[j]) {
					right[i] += 1;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < left.length - 1; i ++) {
			for (int j = i + 1; j < left.length; j++) {
				if (rating[j] > rating[i]) {
					res += left[i];
				}
			}
		}

		for (int i = right.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (rating[j] > rating[i]) {
					res += right[i];
				}
			}
		}


		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numTeams(new int[]{2,5,3,4,1});
	}
}