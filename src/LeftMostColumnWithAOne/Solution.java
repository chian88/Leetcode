package LeftMostColumnWithAOne;
import java.util.*;



class Solution {

	static class BinaryMatrix {
		private List<List<Integer>> cache = new ArrayList<>();
		public int get(int row, int col) {
			return cache.get(row).get(col);
		};
		public List<Integer> dimensions() {
			List<Integer> arr = new ArrayList<>();
			arr.add(cache.size());
			arr.add(cache.get(0).size());
			return arr;
		};

		BinaryMatrix() {
			cache.add(Arrays.asList(0,0));
			cache.add(Arrays.asList(1,1));
		}
	};

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

		List<Integer> dimension = binaryMatrix.dimensions();

		int rows = dimension.get(0);
		int cols = dimension.get(1);

		int minFirstOne = Integer.MAX_VALUE;
		for (int i = 0; i < rows; i++) {
			int currfirstOne = findFirstOne(i, cols, binaryMatrix);
			minFirstOne = Math.min(currfirstOne, minFirstOne);
		}

		return minFirstOne == Integer.MAX_VALUE ? -1 : minFirstOne;
	}

	public int findFirstOne(int row, int col, BinaryMatrix binaryMatrix) {
		int lo = 0;
		int hi = col;
		boolean found = false;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (binaryMatrix.get(row, mid) == 1) {
				found = true;
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		if (found) {
			return lo;
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.leftMostColumnWithOne(new BinaryMatrix());
	}
}