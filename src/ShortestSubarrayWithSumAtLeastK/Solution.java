package ShortestSubarrayWithSumAtLeastK;
import java.util.*;

//
//class Solution {
//	public int shortestSubarray(int[] nums, int k) {
//		int left = -1;
//		int right = 0;
//		int currSum = nums[0];
//		int res = Integer.MAX_VALUE;
//		while (right < nums.length) {
//			if (currSum < k) {
//				// try to expand.
//				right++;
//				if (right < nums.length) {
//					currSum += nums[right];
//				}
//
//			} else if (currSum >= k) {
//				// try to shrink.
//				res = Math.min(res, right - left);
//				left++;
//				if (left < nums.length) {
//					currSum -= nums[left];
//				}
//
//			}
//		}
//		right--;
//		while (left < nums.length) {
//
//
//			left++;
//			if (left < nums.length) {
//				currSum -= nums[left];
//			}
//
//			if (currSum >= k) {
//				res = Math.min(res, right - left);
//			}
//		}
//
//		return res == Integer.MAX_VALUE ? -1 : res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.shortestSubarray(new int[]{-28,81,-20,28,-29}, 89);
//	}
//}

class Solution {
	public int shortestSubarray(int[] A, int K) {
		int N = A.length;
		long[] P = new long[N+1];
		for (int i = 0; i < N; ++i)
			P[i+1] = P[i] + (long) A[i];

		// Want smallest y-x with P[y] - P[x] >= K
		int ans = N+1; // N+1 is impossible
		Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

		for (int y = 0; y < P.length; ++y) {
			// Want opt(y) = largest x with P[x] <= P[y] - K;
			while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
				monoq.removeLast();
			while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
				ans = Math.min(ans, y - monoq.removeFirst());

			monoq.addLast(y);
		}

		return ans < N+1 ? ans : -1;
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		test.shortestSubarray(new int[]{-28,81,-20,28,-29}, 89);
	}
}