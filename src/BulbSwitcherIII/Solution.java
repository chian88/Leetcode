package BulbSwitcherIII;
import java.util.*;


class Solution {
	public int numTimesAllBlue(int[] light) {
		int res = 0;
		int previousBlue = -1;
		for (int i = 0; i < light.length; i++) {
			int idx = Math.abs(light[i]);

			light[idx - 1] = Math.abs(light[idx - 1]) * -1;

			while (previousBlue + 1 < light.length &&
					light[previousBlue + 1] < 0) {
				previousBlue += 1;
			}

			if (previousBlue == i) {
				res += 1;
			}

		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numTimesAllBlue(new int[] {3,2,4,1,5});
	}
}