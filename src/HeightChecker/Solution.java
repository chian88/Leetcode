package HeightChecker;
import java.util.*;

class Solution {
	public int heightChecker(int[] heights) {
		int[] copied = Arrays.copyOfRange(heights, 0, heights.length);
		Arrays.sort(copied);
		int res = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != copied[i]) {
				res += 1;
			}
		}

		return res;
	}
}