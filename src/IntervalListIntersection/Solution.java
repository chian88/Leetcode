package IntervalListIntersection;

import java.util.*;

class Solution {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int ptrA = 0;
		int ptrB = 0;

		List<int[]> intersection = new ArrayList<>();

		while (ptrA < A.length && ptrB < B.length) {
			int[] res = new int[]{-1, -1};

			int[] timeA = A[ptrA];
			int[] timeB = B[ptrB];
			if (timeA[0] <= timeB[1] && timeA[0] >= timeB[0]) {
				res[0] = timeA[0];
			} else if (timeB[0] <= timeA[1] && timeB[0] >= timeA[0]) {
				res[0] = timeB[0];
			}

			if (res[0] >= 0 && timeA[1] <= timeB[1]) {
				res[1] = timeA[1];
				intersection.add(res);
			} else if (res[0] >=0 && timeB[1] <= timeA[1]) {
				res[1] = timeB[1];
				intersection.add(res);
			}

			if (timeA[1] <= timeB[1]) {
				ptrA++;
			} else {
				ptrB++;
			}


		}

		int[][] res = new int[intersection.size()][2];

		for (int i = 0 ; i < intersection.size(); i++) {
			res[i] = intersection.get(i);
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();

		test.intervalIntersection(new int[][]{{0,2}, {5,10}, {13,23}, {24,25}}, new int[][] {{1,5}, {8,12}, {15,24}, {25,26}});
	}
}