package SmallestRangeCoveringElementsFromKList;
import java.util.*;


public class Solution {
	public int[] smallestRange(int[][] nums) {
		int minx = 0, miny = Integer.MAX_VALUE;
		int[] next = new int[nums.length];
		boolean flag = true;
		for (int i = 0; i < nums.length && flag; i++) {
			for (int j = 0; j < nums[i].length && flag; j++) {
				int min_i = 0, max_i = 0;
				for (int k = 0; k < nums.length; k++) {
					if (nums[min_i][next[min_i]] > nums[k][next[k]])
						min_i = k;
					if (nums[max_i][next[max_i]] < nums[k][next[k]])
						max_i = k;
				}
				if (miny - minx > nums[max_i][next[max_i]] - nums[min_i][next[min_i]]) {
					miny = nums[max_i][next[max_i]];
					minx = nums[min_i][next[min_i]];
				}
				next[min_i]++;
				if (next[min_i] == nums[min_i].length) {
					flag = false;
				}
			}
		}
		return new int[] {minx, miny};
	}
}