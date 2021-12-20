package DotProductOfTwoSparseVectors;

import java.util.*;

class SparseVector {
	HashMap<Integer, Integer> hm = new HashMap<>();
	SparseVector(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				hm.put(i, nums[i]);
			}
		}
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(SparseVector vec) {
		int sum = 0;
		for (int idx : hm.keySet()) {
			if (vec.hm.containsKey(idx)) {
				sum += hm.get(idx) * vec.hm.get(idx);
			}
		}

		return sum;
	}
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);