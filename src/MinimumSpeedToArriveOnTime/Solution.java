package MinimumSpeedToArriveOnTime;
import java.util.*;


class Solution {
	public int minSpeedOnTime(int[] dist, double hour) {
		int min = 1;
		int max = Integer.MAX_VALUE;


		while (min < max) {
			int middle = min + (max - min) / 2;
			double requiredHours = findRequired(dist, middle);

			if (requiredHours < hour) {
				max = middle;
			} else if (requiredHours > hour){
				min = middle + 1;
			} else {
				return middle;
			}
		}
		double requiredHours = findRequired(dist, min);

		if (requiredHours < hour) {
			return min;
		}
		return -1;

	}

	double findRequired(int[] dist, int speed) {
		double res = 0;
		for (int i = 0; i < dist.length; i++) {
			if (i == dist.length - 1) {
				res += dist[i] * 1.0 / speed;
			}else {
				res += Math.ceil(dist[i] * 1.0 / speed);
			}


		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minSpeedOnTime(new int[]{1, 1, 100000}, 2.01);
	}
}