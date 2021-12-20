package MagneticForceBetweenTwoBalls;
import java.util.*;

class Solution {
	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);

		int min = 1;
		int max = position[position.length - 1] - position[0];

		while (min <= max) {
			int mid = min + (max - min) / 2;

			if (countBall(mid, position) >= m) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return max;

	}

	int countBall(int d, int[] position) {
		int count = 1;
		int curr = position[0];

		for (int i = 1; i < position.length; i++) {
			if (position[i] - curr >= d) {
				count++;
				curr = position[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxDistance(new int[]{1,2,3,4,7}, 3);
	}
}