package NumOfWeakCharacters;
import java.util.*;

class Solution {
	public int numberOfWeakCharacters(int[][] properties) {
		Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		int max = Integer.MIN_VALUE;
		int ans = 0;
		for (int i = properties.length - 1; i >= 0; i--) {
			if (max > properties[i][1]) {
				ans++;
			} else {
				max = properties[i][1];
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.numberOfWeakCharacters(new int[][]{{10,1}, {5,1}, {7,10}, {4,1}, {5,9}, {6,9}, {7,2}, {1,10}});
	}
}