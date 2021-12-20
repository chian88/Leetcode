package MaximumPointsYouCanObtainFromCard;
import java.util.*;

class Solution {
	public int maxScore(int[] cardPoints, int k) {
		int[] left = new int[k + 1];
		int[] right = new int[k + 1];
		int n = cardPoints.length;
		for (int i = 0; i < k; i ++) {
			left[i + 1] = left[i] + cardPoints[i];
			right[k - i - 1] = right[k - i] + cardPoints[n - i - 1];
		}
		int res = 0;
		for (int i = 0; i <= k; i++) {
			int currScore = left[i] + right[i];
			res = Math.max(res, currScore);

		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxScore(new int[]{1,79,80,1,1,1,200,1}, 3);
	}
}