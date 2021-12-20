package FindKPairsWithSmallestSum;
import java.util.*;


class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[][]> heap = new PriorityQueue<>( (a , b) -> {
			return (a[0][1] + a[1][1]) - (b[0][1] + b[1][1]);
		});
		heap.add(new int[][] {{0, nums1[0]}, {0, nums2[0]}});
		Set<List<Integer>> seen = new HashSet<>();
		seen.add(Arrays.asList(0,0));
		List<List<Integer>> res = new ArrayList<>();
		while (!heap.isEmpty() && k > 0) {
			int[][] smallestPair = heap.poll();

			res.add(Arrays.asList(smallestPair[0][1], smallestPair[1][1]));

			if (smallestPair[0][0] + 1 < nums1.length) {
				int idx1 = smallestPair[0][0] + 1;
				int idx2 = smallestPair[1][0];
				if (!seen.contains(Arrays.asList(idx1, idx2))) {
					seen.add(Arrays.asList(idx1, idx2));
					heap.add(new int[][]{{idx1, nums1[idx1] }, {idx2, nums2[idx2]}});
				}

			}

			if (smallestPair[1][0] + 1 < nums2.length) {
				int idx1 = smallestPair[0][0];
				int idx2 = smallestPair[1][0] + 1;
				if (!seen.contains(Arrays.asList(idx1, idx2))) {
					seen.add(Arrays.asList(idx1, idx2));
					heap.add(new int[][]{{idx1, nums1[idx1] }, {idx2, nums2[idx2]}});
				}

			}
			k--;
		}



		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.kSmallestPairs(new int[]{1,7,11}, new int[]{1,4,6}, 10);
	}
}