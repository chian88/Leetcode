package KoKoEatingBanana;
import java.util.*;

class Solution {
	public static int minEatingSpeed(int[] piles, int h) {
		int lo = 1;
		int hi = 1000000000;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (!possible(piles, h, mid)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return lo;
	}

	public static boolean possible(int[] piles, int H, int K) {
		int time = 0;
		for (int p : piles) {
			time += Math.ceil(p / K);
		}

		return time <= H;
	}

	public static void main(String[] args) {
		minEatingSpeed(new int[]{3,6,7,11}, 8);
	}


}