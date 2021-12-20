package FurthestBuildingYouCanReach;
import java.util.*;


class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> ladderHeap = new PriorityQueue<>();

		int totalbricksUsed = 0;
		for (int i = 0 ; i < heights.length; i++) {
			if (i == heights.length - 1) {
				return i;
			}
			int diff = heights[i + 1] - heights[i];
			if (diff < 0) {
				continue;
			}
			if (ladderHeap.size() < ladders) {
				ladderHeap.add(diff);
				diff = 0;
			} else if (!ladderHeap.isEmpty() && diff > ladderHeap.peek()) {
				int temp = ladderHeap.poll();
				ladderHeap.add(diff);
				diff = temp;
			}
			totalbricksUsed += diff;

			if (totalbricksUsed > bricks) {
				return i;
			}
		}

		return heights.length - 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.furthestBuilding(new int[]{14,3,19,3}, 17, 0);
	}
}