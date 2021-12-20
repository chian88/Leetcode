package MaximumUnitsOnATruck;
import java.util.*;
class Solution {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (o1, o2) -> {
			return o2[1] - o1[1];
		});

		int currBox = 0;
		int ptr = 0;
		int res = 0;
		while (currBox < truckSize && ptr < boxTypes.length) {
			int maxAmount = Math.min(boxTypes[ptr][0], truckSize - currBox);
			res += maxAmount * boxTypes[ptr][1] ;

			currBox += maxAmount;
			ptr++;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maximumUnits(new int[][]{{1,3}, {2,2}, {3,1}}, 4);
	}
}